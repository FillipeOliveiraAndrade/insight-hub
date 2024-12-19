package br.com.fillipeoliveira.insight_hub.modules.user.dtos;

import br.com.fillipeoliveira.insight_hub.modules.user.models.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserResponseDTO {
  private User user;
  private String token;
}
