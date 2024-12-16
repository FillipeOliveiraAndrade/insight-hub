package br.com.fillipeoliveira.insight_hub.modules.product.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyNotFoundException;
import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import br.com.fillipeoliveira.insight_hub.modules.company.models.repositories.CompanyRepository;
import br.com.fillipeoliveira.insight_hub.modules.product.models.entities.Product;
import br.com.fillipeoliveira.insight_hub.modules.product.models.repositories.ProductRepository;

@Service
public class ProductService {
  
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CompanyRepository companyRepository;

  public Product save(Product product, UUID companyId) {
    Company company = this.companyRepository.findById(companyId)
        .orElseThrow(() -> new CompanyNotFoundException());

    product.setCompany(company);
    return this.productRepository.save(product);
  }
}
