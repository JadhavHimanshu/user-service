package org.dnyanyog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserData {
  @NotNull(message = "Id should not be null")
  private Long userId;

  @NotBlank(message = "UserName is Mandatory")
  private String name;

  @NotBlank(message = "UserName is Mandatory")
  @Pattern(
      regexp = "^[a-zA-Z0-9._-]{3,30}$",
      message = 
          "Username must be 3-30 characters long and can contain letters, numbers, dots, underscores, and hyphens.")
  @Size(min = 3, max = 50, message = "Name must between 3 to 50 characters ")
  private String userName;

  @NotBlank(message = "Password is mandatory")
  @Pattern(
      regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
      message =
          "Password must be 8-20 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character (@$!%*?&).")
  @Size(min = 3, max = 30, message = "Passwoerd must be between 8 to 30 chatracters ")
  private String password;

  private String confirmPassword;
  private String newPassword;

  @Pattern(
      regexp = "\\d{4}-\\d{2}-\\d{2}",
      message = "Password expiry must be in YYYY-MM-DD format")
  private String passwordExpiry;

  @NotBlank(message = " Role is mandatory")
  private String userRole;

  @NotBlank(message = "User Status is mandatory")
  private String userStatus;

  @NotBlank(message = "TenantId is mandatory")
  private String tenatId;

  @NotBlank(message = "Tenant is mandatory")
  private String tenant;

  @NotBlank(message = "Department is mandatory")
  private String department;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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

  public String getPasswordExpiry() {
    return passwordExpiry;
  }

  public void setPasswordExpiry(String passwordExpiry) {
    this.passwordExpiry = passwordExpiry;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(String userStatus) {
    this.userStatus = userStatus;
  }

  public String getTenatId() {
    return tenatId;
  }

  public void setTenatId(String tenatId) {
    this.tenatId = tenatId;
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }
}
