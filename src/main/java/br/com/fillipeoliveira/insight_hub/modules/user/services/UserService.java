package br.com.fillipeoliveira.insight_hub.modules.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fillipeoliveira.insight_hub.modules.user.exceptions.UserEmailAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.user.models.entities.User;
import br.com.fillipeoliveira.insight_hub.modules.user.models.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User save(User user) {
    validateUser(user);

    var password = passwordEncoder.encode(user.getPassword());
    user.setPassword(password);

    return this.userRepository.save(user);
  }

    private void validateUser(User user) {
      this.userRepository.findByEmail(user.getEmail())
          .ifPresent(existingUser -> {
            throw new UserEmailAlreadyExistsException();
          });
  }
}
