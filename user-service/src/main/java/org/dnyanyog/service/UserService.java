package org.dnyanyog.service;

import java.util.List;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Configuration
public interface UserService {

  public UserResponse addOrUpdateUser(UserRequest request);

  public UserResponse findByuserId(Long userId);

  public List<UserResponse> getAllUsers(UserRequest request);

  public UserResponse deleteByuserId(Long userId);

  public boolean validateUser(String userName, String password);

  public boolean changePassword(String userName, String currentPassword, String newPassword);
}
