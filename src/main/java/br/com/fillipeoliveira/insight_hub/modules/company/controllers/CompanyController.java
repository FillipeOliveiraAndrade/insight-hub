package br.com.fillipeoliveira.insight_hub.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fillipeoliveira.insight_hub.modules.company.dtos.CompanyDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.services.CompanyService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyService companyService;
  
  @PostMapping
  @PreAuthorize("hasRole('COMPANY')")
  public ResponseEntity<Company> create(@Valid @RequestBody CompanyDTO companyDTO) {
    Company result = this.companyService.save(companyDTO.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
  
}
