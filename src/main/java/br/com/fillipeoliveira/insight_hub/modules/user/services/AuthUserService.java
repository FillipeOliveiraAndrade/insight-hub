package br.com.fillipeoliveira.insight_hub.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fillipeoliveira.insight_hub.modules.user.dtos.AuthUserDTO;
import br.com.fillipeoliveira.insight_hub.modules.user.dtos.AuthUserResponseDTO;
import br.com.fillipeoliveira.insight_hub.modules.user.exceptions.UserNotFoundExcepiton;
import br.com.fillipeoliveira.insight_hub.modules.user.models.entities.User;
import br.com.fillipeoliveira.insight_hub.modules.user.models.repositories.UserRepository;

@Service
public class AuthUserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TokenServiceUser tokenServiceUser;
  
  @Autowired
  private PasswordEncoder passwordEncoder;

  public AuthUserResponseDTO auth(AuthUserDTO authUserDTO) {
    User user = this.userRepository.findByEmail(authUserDTO.email())
        .orElseThrow(() -> new UserNotFoundExcepiton());

    boolean passwordMatches = passwordEncoder.matches(authUserDTO.password(), user.getPassword());
    if (!passwordMatches) {
      throw new UserNotFoundExcepiton();
    }

    String token = this.tokenServiceUser.generateToken(user);

    AuthUserResponseDTO tokenDTO = AuthUserResponseDTO
        .builder()
        .user(user)
        .token(token)
        .build();

    return tokenDTO;
  }
}
