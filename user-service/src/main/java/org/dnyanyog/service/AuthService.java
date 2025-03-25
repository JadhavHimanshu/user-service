package org.dnyanyog.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Optional;
import org.dnyanyog.entity.User;
import org.dnyanyog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired private UserRepo userRepository;
  @Lazy @Autowired private PasswordEncoder passwordEncoder;

  private final String SECRET_KEY = "YoxN5n0EtIWL7n0t85qwQefmiOsrFxonpfjwF8uvGvE=";
  private final long EXPIRATION_TIME = 86400000;

  public String getSecretKey() {
    return SECRET_KEY;
  }

  public String generateToken(User user) {
    return Jwts.builder()
        .setSubject(user.getUserName())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
        .compact();
  }

  public Optional<User> authenticate(String username, String password) {
    Optional<User> user = userRepository.findByUserName(username);

    if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
      return Optional.of(user.get());
    }

    return Optional.empty();
  }
}
