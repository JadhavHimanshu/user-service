package org.dnyanyog.service;

import java.util.Optional;
import org.dnyanyog.entity.User;
import org.dnyanyog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private UserRepo userRepo;

  public UserDetails loadUserByUsername(String username) {
    Optional<User> userOptional = userRepo.findByUserName(username);

    if (!userOptional.isPresent()) {

      return null;
    }

    User user = userOptional.get();

    return org.springframework.security.core.userdetails.User.builder()
        .username(user.getUserName()) // Set username
        .password(user.getPassword()) // Set encoded password
        .roles("USER") // Assign role (adjust if you have different roles)
        .build();
  }
}
