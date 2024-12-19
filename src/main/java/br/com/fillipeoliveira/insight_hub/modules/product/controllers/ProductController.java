package br.com.fillipeoliveira.insight_hub.modules.product.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fillipeoliveira.insight_hub.modules.product.models.entities.Product;
import br.com.fillipeoliveira.insight_hub.modules.product.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> get() {
    List<Product> products = this.productService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
    Product product = this.productService.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(product);
  }

  @GetMapping("/image/{productId}")
  public ResponseEntity<byte[]> viewImages(@PathVariable UUID productId) {
    byte[] images = this.productService.getImages(productId);
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, "image/png")
            .body(images);
  }
}
