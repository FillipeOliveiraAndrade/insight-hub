package br.com.fillipeoliveira.insight_hub.modules.company.services;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;

@Service
public class TokenService {
  
  @Value("api.security.token.secret")
  private String secret;

  public String generateToken(Company company) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    
    String token = JWT.create()
        .withIssuer("insighthub-api")
        .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
        .withSubject(company.getUsername())
        .sign(algorithm);

    return token;
  }
}
