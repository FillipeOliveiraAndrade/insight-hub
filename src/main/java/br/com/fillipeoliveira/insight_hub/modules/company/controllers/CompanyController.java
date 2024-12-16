package br.com.fillipeoliveira.insight_hub.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fillipeoliveira.insight_hub.modules.company.dtos.CompanyDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.services.CompanyService;
import br.com.fillipeoliveira.insight_hub.modules.product.dtos.ProductDTO;
import br.com.fillipeoliveira.insight_hub.modules.product.models.entities.Product;
import br.com.fillipeoliveira.insight_hub.modules.product.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

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

  @Autowired
  private ProductService productService;
  
  @PostMapping
  public ResponseEntity<Company> create(@Valid @RequestBody CompanyDTO companyDTO) {
    Company result = this.companyService.save(companyDTO.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
  
  @PostMapping("/product")
  @PreAuthorize("hasRole('COMPANY')")
  public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO, HttpServletRequest request) {
    var companyId = request.getAttribute("company_id");

    Product result = this.productService.save(productDTO.toEntity(), UUID.fromString(companyId.toString()));
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }
}
