package br.com.fillipeoliveira.insight_hub.modules.product.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

  public List<Product> findAll() {
    List<Product> products = this.productRepository.findAll();
    return products;
  }

  public byte[] getImages(UUID id) {
    Optional<Product> product = this.productRepository.findById(id);

    if (product.isPresent()) {
      return product.get().getImages();
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imagem não encontrada");
    }
  }

  public Product findById(UUID id) {
    Optional<Product> product = this.productRepository.findById(id);
    return product.get();
  }

  public List<Product> findProductsByCompanyId(UUID companyId) {
    List<Product> products = this.productRepository.findByCompanyId(companyId);
    return products;
  }
}
