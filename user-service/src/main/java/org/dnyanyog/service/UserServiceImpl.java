package org.dnyanyog.service;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.User;
import org.dnyanyog.mapper.UserMapper;
import org.dnyanyog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class UserServiceImpl implements UserService {
  @Autowired UserRepo repo;
  @Lazy @Autowired private PasswordEncoder passwordEncoder;

  @Override
  public UserResponse addOrUpdateUser(@Valid UserRequest request) {
    UserResponse response = new UserResponse();
    Optional<User> userData = this.repo.findByuserId(request.getUserId());
    if (userData.isPresent()) {
      User updateUser = UserMapper.toEntity(request);
      User saveUser = repo.save(updateUser);
      response =
          UserMapper.toDto(
              saveUser, ResponseCode.Update_User.getCode(), ResponseCode.Add_User.getMessage());
    } else {
      User user = UserMapper.toEntity(request);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      User saveUser = repo.save(user);
      response =
          UserMapper.toDto(
              saveUser, ResponseCode.Add_User.getCode(), ResponseCode.Add_User.getMessage());
    }
    return response;
  }

  public boolean changePassword(String userName, String currentPassword, String newPassword) {
    Optional<User> optionalUser = repo.findByUserName(userName);

    if (optionalUser.isPresent()) {
      User existingUser = optionalUser.get();
      if (existingUser.getPassword().equals(currentPassword)) {
        existingUser.setPassword(newPassword);
        repo.save(existingUser);
        return true;
      }
    }

    return false;
  }

  public boolean validateUser(String userName, String password) {
    Optional<User> user = repo.findByUserName(userName);

    if (user.isPresent() && user.get().getPassword().equals(password)) {
      return true;
    }
    return false;
  }

  @Override
  public UserResponse findByuserId(@Valid Long userId) {
    Optional<User> userData = this.repo.findByuserId(userId);
    if (userData.isPresent()) {
      return UserMapper.toDto(
          userData.get(),
          ResponseCode.Search_User.getMessage(),
          ResponseCode.Search_User.getCode());
    }
    return null;
  }

  @Override
  public List<UserResponse> getAllUsers(UserRequest request) {
    return null;
  }

  @Override
  public UserResponse deleteByuserId(Long userId) {
    UserResponse response = new UserResponse();
    Optional<User> inventoryData = this.repo.findByuserId(userId);
    if (inventoryData.isPresent()) {
      Long rowDeleted = repo.deleteByuserId(userId);
      if (rowDeleted > 0) {
        response.setMessage(ResponseCode.Delete_User.getMessage());
        response.setCode(ResponseCode.Delete_User.getCode());
      }
    }
    return response;
  }
}
