package br.com.fillipeoliveira.insight_hub.modules.user.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserResponseDTO {
  private String token;
}
