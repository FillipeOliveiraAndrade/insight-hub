package br.com.fillipeoliveira.insight_hub.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fillipeoliveira.insight_hub.modules.company.dtos.CompanyDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyService companyService;
  
  @PostMapping
  public ResponseEntity<Company> create(@RequestBody CompanyDTO companyDTO) {
    Company result = this.companyService.save(companyDTO.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
  
}
