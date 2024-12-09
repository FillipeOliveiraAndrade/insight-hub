package br.com.fillipeoliveira.insight_hub.modules.company.dtos;

import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;

public record CompanyDTO(
  String email,
  String cnpj,
  String password
) {
  
  public Company toEntity() {
    return Company
        .builder()
        .email(this.email)
        .cnpj(this.cnpj)
        .password(this.password)
        .build();
  }
}
