package br.com.fillipeoliveira.insight_hub.modules.product.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;
  private String description;

  // private void images;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
