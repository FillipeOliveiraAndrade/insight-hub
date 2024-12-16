package br.com.fillipeoliveira.insight_hub.modules.company.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthCompanyResponseDTO {
  private String token;
}
