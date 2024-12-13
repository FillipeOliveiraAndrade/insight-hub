package br.com.fillipeoliveira.insight_hub.modules.company.models.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
  Optional<Company> findByCnpj(String cnpj);
  Optional<Company> findByEmail(String email);
  Optional<Company> findByUsername(String username);
}
