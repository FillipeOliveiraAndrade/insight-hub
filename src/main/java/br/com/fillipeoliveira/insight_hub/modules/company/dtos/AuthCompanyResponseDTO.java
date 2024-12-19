package br.com.fillipeoliveira.insight_hub.modules.company.dtos;

import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthCompanyResponseDTO {
  private Company company;
  private String token;
}
