package org.dnyanyog.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;

public class User {  
	 private Long  userId ; 
	 @Column(name ="name")
	private String name;  
	  @Column ( name = "username")
	private String userName;  
	@Column(name ="password")
	private String password; 
	 @Column(name="pass_expiry_date")
	private LocalDate passwordExpiryDate; 
	 @Column(name="userrole")
	private String userRole; 
	 @Column(name="user_status")
	private String userStatus; 
	 @Column(name="tenand_id")
	private String tenatId; 
     @Column(name="tenant")
	private String tenant; 
	 @Column(name="department")
	private String department;

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

	public LocalDate getPasswordExpiryDate() {
		return passwordExpiryDate;
	}

	public void setPasswordExpiryDate(LocalDate passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
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

}
