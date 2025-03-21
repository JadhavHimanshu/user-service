package org.dnyanyog.controller;

import io.jsonwebtoken.JwtException;
import jakarta.validation.Valid;
import java.util.List;
import org.dnyanyog.dto.ChangePasswordRequest;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.service.UserService;
import org.dnyanyog.utilis.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Component
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
  @Autowired private JwtUtil jwtUtil;

  @Autowired private UserService userService;

  @PostMapping(
      path = "/api/v1/auth/user",
      consumes = {"application/json", "application/xml"},
      produces = {" application/json", "application/xml"})
  public UserResponse addOrUpdateUser(@Valid @RequestBody UserRequest request) {
    if (request.getUserId() == null || request.getUserId() <= 0) {
      return userService.addOrUpdateUser(request);
    } else {
      return userService.addOrUpdateUser(request);
    }
  }

  @PostMapping("/api/v1/auth/login")
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
    System.out.println("Received Request: " + loginRequest);

    boolean isValid =
        userService.validateUser(loginRequest.getUserName(), loginRequest.getPassword());

    if (isValid) {
      try {
        // ✅ Use the injected `jwtUtil` instance correctly
        String token = jwtUtil.generateToken(loginRequest.getUserName());
        System.out.println("Generated Token: " + token);
        return ResponseEntity.ok().body(token);
      } catch (JwtException e) {
        System.err.println("JWT Token Generation Error: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error generating token. Please try again.");
      }
    } else {
      System.err.println("Invalid Credentials for User: " + loginRequest.getUserName());
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
  }

  @GetMapping(path = "/api/v1/auth/user_seacrh/{userId}")
  public ResponseEntity<UserResponse> searchCandidate(@Valid @PathVariable Long userId) {
    UserResponse response = userService.findByuserId(userId);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/api/v1/auth/change_password")
  public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest request) {

    if (!request.getNewPassword().equals(request.getConfirmPassword())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("New password and confirm password must be the same.");
    }

    boolean isPasswordUpdated =
        userService.changePassword(
            request.getUserName(), request.getPassword(), request.getNewPassword());

    if (isPasswordUpdated) {
      return ResponseEntity.ok("Password updated successfully.");
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("Invalid username or current password.");
    }
  }

  @GetMapping(path = "/api/v1/auth/users")
  //   produces = {"application/json", "application/xml"})
  public ResponseEntity<List<UserResponse>> getAllUsers(@RequestBody UserRequest request) {
    List<UserResponse> users = userService.getAllUsers(request);
    return ResponseEntity.ok(users);
  }

  @DeleteMapping(path = "/api/v1/user/user_delete/{userId}")
  public UserResponse deleteUser(@Valid @PathVariable Long userId) {
    return userService.deleteByuserId(userId);
  }
}
