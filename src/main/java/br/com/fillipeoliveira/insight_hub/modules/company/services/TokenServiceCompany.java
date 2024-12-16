package br.com.fillipeoliveira.insight_hub.modules.company.services;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;

@Service
public class TokenServiceCompany {
  
  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(Company company) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token = JWT.create()
          .withIssuer("insighthub-api")
          .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
          .withSubject(company.getId().toString())
          .withClaim("roles", Arrays.asList("COMPANY"))
          .sign(algorithm);
  
      return token;
    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro ao gerar o token");
    }
  }

  public DecodedJWT validateToken(String token) {
    token = token.replace("Bearer ", "");

    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
          .build()
          .verify(token);
    } catch (JWTVerificationException e) {
      throw new RuntimeException("Token inválido ou expirado");
    }
    

  }
}
