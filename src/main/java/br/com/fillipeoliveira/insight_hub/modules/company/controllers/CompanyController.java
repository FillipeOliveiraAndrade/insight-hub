package br.com.fillipeoliveira.insight_hub.modules.company.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.fillipeoliveira.insight_hub.modules.company.dtos.CompanyDTO;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.services.CompanyService;
import br.com.fillipeoliveira.insight_hub.modules.product.dtos.ProductDTO;
import br.com.fillipeoliveira.insight_hub.modules.product.models.entities.Product;
import br.com.fillipeoliveira.insight_hub.modules.product.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

  @PostMapping(value = "/product", consumes = { "multipart/form-data" })
  @PreAuthorize("hasRole('COMPANY')")
  public ResponseEntity<Product> createProduct(
      @RequestPart("product") ProductDTO productDTO,
      @RequestPart("images") MultipartFile[] images,
      HttpServletRequest request) {

    var companyId = request.getAttribute("company_id");

    Product result = this.productService.save(
        productDTO.toEntity(images), UUID.fromString(companyId.toString()));

    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @GetMapping("/product/{companyId}")
  public ResponseEntity<List<Product>> getProductOfCompany(@PathVariable UUID companyId) {
    List<Product> product = this.productService.findProductsByCompanyId(companyId);
    return ResponseEntity.status(HttpStatus.OK).body(product);
  }
}
