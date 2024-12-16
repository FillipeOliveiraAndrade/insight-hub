package br.com.fillipeoliveira.insight_hub.modules.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fillipeoliveira.insight_hub.modules.user.dtos.AuthUserDTO;
import br.com.fillipeoliveira.insight_hub.modules.user.dtos.AuthUserResponseDTO;
import br.com.fillipeoliveira.insight_hub.modules.user.services.AuthUserService;

@RestController
@RequestMapping("/auth/user")
public class AuthUserController {
  
  @Autowired
  private AuthUserService authUserService;

  @PostMapping
  public ResponseEntity<AuthUserResponseDTO> login(@RequestBody AuthUserDTO authUserDTO) {
    AuthUserResponseDTO token = this.authUserService.auth(authUserDTO);
    return ResponseEntity.ok(token);
  }
}
