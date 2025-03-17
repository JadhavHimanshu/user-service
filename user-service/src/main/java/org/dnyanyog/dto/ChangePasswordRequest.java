package org.dnyanyog.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordRequest {
  @NotBlank(message = "UserName is mandatory")
  private String userName;

  @NotBlank(message = "Current password is mandatory")
  private String password;

  @NotBlank(message = "New password is mandatory")
  private String newPassword;

  @NotBlank(message = "Confirm password is mandatory")
  private String confirmPassword;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}
