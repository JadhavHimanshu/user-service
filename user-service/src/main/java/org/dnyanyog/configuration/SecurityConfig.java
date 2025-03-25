package org.dnyanyog.configuration;

import org.dnyanyog.filter.JwtFilter;
import org.dnyanyog.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private final JwtFilter jwtFilter;
  private final CustomUserDetailsService customUserDetailsService;

  public SecurityConfig(JwtFilter jwtFilter, CustomUserDetailsService customUserDetailsService) {
    this.jwtFilter = jwtFilter;
    this.customUserDetailsService = customUserDetailsService;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            authorize ->
                authorize
                    .requestMatchers("/api/v1/auth/user", "/api/v1/auth/login")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public BCryptPasswordEncoder bcryptpasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
