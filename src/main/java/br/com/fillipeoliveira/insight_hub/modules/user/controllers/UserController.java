package br.com.fillipeoliveira.insight_hub.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fillipeoliveira.insight_hub.modules.user.dtos.UserDTO;
import br.com.fillipeoliveira.insight_hub.modules.user.models.entities.User;
import br.com.fillipeoliveira.insight_hub.modules.user.services.UserService;
import jakarta.validation.Valid;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private UserService userService;

  @PostMapping
  private ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO) {
    User result = this.userService.save(userDTO.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
}
