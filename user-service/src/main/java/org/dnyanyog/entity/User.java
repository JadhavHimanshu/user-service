package org.dnyanyog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "User_Management")
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  @JsonIgnore
  @Column(name = "name")
  private String name;

  @Column(name = "username")
  private String userName;

  @Column(name = "password")
  private String password;

  @Column(name = "confirm_password")
  private String confirmPassword;

  @Column(name = "new_password")
  private String newPassword;

  @JsonIgnore
  @Column(name = "pass_expiry_date")
  private LocalDate passwordExpiryDate;

  @JsonIgnore
  @Column(name = "userrole")
  private String userRole;

  @JsonIgnore
  @Column(name = "user_status")
  private String userStatus;

  @JsonIgnore
  @Column(name = "tenant_id")
  private String tenantId;

  @JsonIgnore
  @Column(name = "tenant")
  private String tenant;

  @JsonIgnore
  @Column(name = "department")
  private String department;

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public User setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public LocalDate getPasswordExpiryDate() {
    return passwordExpiryDate;
  }

  public User setPasswordExpiryDate(LocalDate passwordExpiryDate) {
    this.passwordExpiryDate = passwordExpiryDate;
    return this;
  }

  public String getUserRole() {
    return userRole;
  }

  public User setUserRole(String userRole) {
    this.userRole = userRole;
    return this;
  }

  public String getUserStatus() {
    return userStatus;
  }

  public User setUserStatus(String userStatus) {
    this.userStatus = userStatus;
    return this;
  }

  public String getTenantId() {
    return tenantId;
  }

  public User setTenantId(String tenantId) {
    this.tenantId = tenantId;
    return this;
  }

  public String getTenant() {
    return tenant;
  }

  public User setTenant(String tenant) {
    this.tenant = tenant;
    return this;
  }

  public String getDepartment() {
    return department;
  }

  public User setDepartment(String department) {
    this.department = department;
    return this;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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

  public static User getInstance() {
    return new User();
  }
}
