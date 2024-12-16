package br.com.fillipeoliveira.insight_hub.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fillipeoliveira.insight_hub.modules.company.dtos.AuthCompanyDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.dtos.AuthCompanyResponseDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.services.AuthCompanyService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/auth/company")
public class AuthCompanyController {
  
  @Autowired
  private AuthCompanyService authCompanyService;

  @PostMapping
  public ResponseEntity<AuthCompanyResponseDTO> login(@RequestBody AuthCompanyDTO authCompanyDTO) {
    AuthCompanyResponseDTO token = this.authCompanyService.auth(authCompanyDTO);
    return ResponseEntity.ok(token);
  }
  
}
