package br.com.fillipeoliveira.insight_hub.modules.user.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String username;
  private String email;
  private String password;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
