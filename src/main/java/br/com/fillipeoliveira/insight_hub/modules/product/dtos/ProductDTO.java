package br.com.fillipeoliveira.insight_hub.modules.product.dtos;

import java.io.IOException;

import br.com.fillipeoliveira.insight_hub.modules.product.models.entities.Product;
import org.springframework.web.multipart.MultipartFile;

public record ProductDTO(
  String name,
  String category,
  String description
) {
  
  public Product toEntity(MultipartFile[] images) {
    Product product = Product.builder()
        .name(this.name)
        .category(this.category)
        .description(this.description)
        .build();

    try {
      if (images != null && images.length > 0) {
        product.setImages(images[0].getBytes());
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }

    return product;
  }
}
