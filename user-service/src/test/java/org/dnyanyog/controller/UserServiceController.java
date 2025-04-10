package org.dnyanyog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // For

import org.dnyanyog.common.ResponseCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jayway.jsonpath.JsonPath;

public class UserServiceController {

  @Autowired MockMvc mockMvc;

  @Test
  public void addUser() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/auth/user")
            .content(
                "{\r\n"
                    + "  \"userId\": 101,\r\n"
                    + "  \"name\": \"Himanshu Jadhav\",\r\n"
                    + "  \"userName\": \"himanshu12234\",\r\n"
                    + "  \"password\": \"SecurePass@123\",\r\n"
                    + "  \"confirmPassword\": \"SecurePass@123\",\r\n"
                    + "  \"passswordExpiry\": \"2025-12-31\",\r\n"
                    + "  \"userRole\": \"ADMIN\",\r\n"
                    + "  \"userStatus\": \"ACTIVE\", \r\n"
                    + "  \"tenant\" : \"Java\",\r\n"
                    + "  \"department\": \"IT\",\r\n"
                    + "  \"tenantId\": \"TEN12345\"\r\n"
                    + "\r\n"
                    + "}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON);
    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value(ResponseCode.Add_User.getCode()))
        .andExpect(jsonPath("$.message").value(ResponseCode.Add_User.getMessage()))
        .andReturn();
  }

  @Test
  public void updateUser() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("\r\n"
        		+ "  \r\n"
        		+ "{\r\n"
        		+ "  \"userId\": 101,\r\n"
        		+ "  \"name\": \"Soham Bhor \",\r\n"
        		+ "  \"userName\": \"soham123\",\r\n"
        		+ "  \"password\": \"SecurePass@123\",\r\n"
        		+ "  \"confirmPassword\": \"SecurePass@123\",\r\n"
        		+ "  \"passswordExpiry\": \"2025-12-31\",\r\n"
        		+ "  \"userRole\": \"ADMIN\",\r\n"
        		+ "  \"userStatus\": \"ACTIVE\", \r\n"
        		+ "  \"tenant\" : \"Java\",\r\n"
        		+ "  \"department\": \"IT\",\r\n"
        		+ "  \"tenantId\": \"TEN1345\"\r\n"
        		+ "\r\n"
        		+ "}\r\n"
        		+ "")
            .content("")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value(ResponseCode.Update_User.getCode()))
        .andExpect(jsonPath("$.message").value(ResponseCode.Update_User.getMessage()))
        .andReturn();
  }

  @Test
  public void serchByID() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/v1/auth/user_seacrh/12");
    mockMvc
        .perform(requestBuilder)
        .andExpect(jsonPath("$.code").value(ResponseCode.Search_User.getCode()))
        .andExpect(jsonPath("$.message").value(ResponseCode.Search_User.getMessage()))
        .andReturn();
  }

  @Test
  public void changePassword() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/change_password");
    mockMvc
        .perform(requestBuilder)
        .andExpect(jsonPath("$code").value(ResponseCode.PASSWORD_RESET.getCode()))
        .andExpect(jsonPath("$.message").value(ResponseCode.PASSWORD_RESET.getMessage()))
        .andReturn();
  }

  @Test
  public void getAllUsers() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/auth/users");
    mockMvc
        .perform(requestBuilder).andExpect(jsonPath("$.code"))) 
        .andExpect(jsonPath("$code").value(ResponseCode.Search_User.getCode()))
        .andExpect(jsonPath("$.message").value(ResponseCode.Search_User.getMessage()))
        .andReturn();
  }

  @Test
  public void deleteByID() throws Exception {
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/v1/user/user_delete/{userId}");
       mockMvc
        .perform(requestBuilder)
      .andExpect(jsonPath("$code").value(ResponseCode.Delete_User.getCode())).andExpect(JsonPath("$message").value(ResponseCode.Delete_User.getMessage())).andReturn();
 
  } 
   @Test 
    public void login()throws Exception {  RequestBuilder requestBuilder =
    MockMvcRequestBuilders.delete("/api/v1/auth/login");
    	 
    }
}
