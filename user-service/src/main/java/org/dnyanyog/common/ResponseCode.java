package org.dnyanyog.common;

public enum ResponseCode {
  Add_User("User Added Sucessfully", "200"),
  Update_User("User Updated Sucessfully", "200"),
  User_Found("User Found ", "200"),
  Delete_User("User Deleted Sucessfully ", "200"),
  User_Not_Found("User Not Found ", "404"),
  Login_Sucess("Login Successful", "200"),
  Login_FAIL("Invalid Username  and Password", "404"),
  PASSWORD_RESET("Password Reset Sucessfully", "200"),
  Password_RESET_FAIL("Password Fail to Update", "404");

  private final String code;
  private final String message;

  private ResponseCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
