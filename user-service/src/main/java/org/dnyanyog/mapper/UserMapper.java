package org.dnyanyog.mapper;

import java.time.LocalDate;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.User;

public class UserMapper {
  public static User toEntity(UserRequest userRequest) {
    return User.getInstance()
        .setUserName(userRequest.getUserName())
        .setName(userRequest.getName())
        .setPasswordExpiryDate(LocalDate.now())
        .setPassword(userRequest.getPassword())
        .setUserRole(userRequest.getUserRole())
        .setUserStatus(userRequest.getUserStatus())
        .setTenant(userRequest.getTenant())
        .setTenantId(userRequest.getTenantId())
        .setDepartment(userRequest.getDepartment())
        .setUserRole(userRequest.getUserRole());
  }

  public static UserResponse toDto(User user, String code, String message) {
    UserResponse response = new UserResponse();
    response.setCode(code);
    response.setMessage(message);
    response.setName(user.getName());
    response.setUserName(user.getUserName());
    response.setPassswordExpiry(user.getPasswordExpiryDate());
    response.setPassword(user.getPassword());
    response.setUserRole(user.getUserRole());
    response.setUserStatus(user.getUserStatus());
    response.setTenant(user.getTenant());
    response.setDepartment(user.getDepartment());
    response.setTenantId(user.getTenantId());
    response.setCode(code);
    return response;
  }
}
