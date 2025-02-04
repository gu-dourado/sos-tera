package br.com.fiap.sos_tera.config.security;

import br.com.fiap.sos_tera.model.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
  @Value("${secret.key}")
  private String secretKey;

  public String generateToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);
      return JWT
              .create()
              .withIssuer("auth")
              .withSubject(user.getEmail())
              .withExpiresAt(generateExpirationDate())
              .sign(algorithm);
    } catch (JWTCreationException error) {
      throw new RuntimeException("Unable to generate token");
    }
  }

  public Instant generateExpirationDate() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secretKey);
      return JWT.require(algorithm)
              .withIssuer("auth")
              .build()
              .verify(token)
              .getSubject();
    } catch (JWTVerificationException error) {
      return "";
    }
  }
}