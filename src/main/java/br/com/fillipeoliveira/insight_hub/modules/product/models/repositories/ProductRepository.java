package br.com.fillipeoliveira.insight_hub.modules.product.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fillipeoliveira.insight_hub.modules.product.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {}
