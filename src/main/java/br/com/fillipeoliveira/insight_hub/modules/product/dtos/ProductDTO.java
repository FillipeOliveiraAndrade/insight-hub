package br.com.fillipeoliveira.insight_hub.modules.product.dtos;

import br.com.fillipeoliveira.insight_hub.modules.product.models.entities.Product;

public record ProductDTO(
  String name,
  String category,
  String description
  // String images
) {

  public Product toEntity() {
    return Product.builder()
        .name(this.name)
        .category(this.category)
        .description(this.description)
        .build();
  }
}