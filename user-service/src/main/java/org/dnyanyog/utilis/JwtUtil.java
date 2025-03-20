package org.dnyanyog.utilis;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
  private String SECRET_KEY = "h2enQiJKDf4VGCbjMAb3GeH5P+hIf5u+ljoseOAcNh0=";
  private static final long EXPIRATION_TIME = 86400000;

  public String generateTikens(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(getSigninKey(), SignatureAlgorithm.HS512)
        .compact();
  }

  public String extractUserName(String token) {
    return Jwts.parserBuilder()
        .setSigningKey(getSigninKey())
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  //  public Date ectractExpiration(String token) {
  //    return extractAllClaims(token).getExpiration();
  //  }
  //   public Claims extractAllClaims (String token ) {
  //	    return Jwts.parser()
  //
  //
  //
  //   } '
  private boolean validateToken(String token, String username) {
    return extractUserName(token).equals(username) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    Date expiration =
        Jwts.parserBuilder()
            .setSigningKey(getSigninKey())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();
    return expiration.before(new Date());
  }

  private Key getSigninKey() {
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
  }
}
