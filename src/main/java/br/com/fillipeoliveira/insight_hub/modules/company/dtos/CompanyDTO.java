package br.com.fillipeoliveira.insight_hub.modules.company.dtos;

import org.hibernate.validator.constraints.Length;

import br.com.fillipeoliveira.insight_hub.modules.company.models.entities.Company;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CompanyDTO(
  @NotBlank(message = "Email cannot be blank.")
  @Email(message = "Please provide a valid email address.")
  String email,

  @NotBlank(message = "Username cannot be blank.")
  @Pattern(regexp = "\\S+", message = "Username cannot contain spaces.")
  String username,

  @NotBlank(message = "CNPJ cannot be blank.")
  @Pattern(
    regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", 
    message = "Please provide a valid CNPJ in the format XX.XXX.XXX/XXXX-XX."
  )
  String cnpj,

  @NotBlank(message = "Password cannot be blank.")
  @Length(min = 8, message = "Password must be at least 8 characters long.")
  String password
) {
  
  public Company toEntity() {
    return Company
        .builder()
        .email(this.email)
        .username(this.username)
        .cnpj(this.cnpj)
        .password(this.password)
        .build();
  }
}
