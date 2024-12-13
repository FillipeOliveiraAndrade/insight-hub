package br.com.fillipeoliveira.insight_hub.modules.user.dtos;

import org.hibernate.validator.constraints.Length;

import br.com.fillipeoliveira.insight_hub.modules.user.models.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDTO(
  @NotBlank(message = "Email cannot be blank.")
  @Email(message = "Please provide a valid email address.")
  String email,

  @NotBlank(message = "Username cannot be blank.")
  @Pattern(regexp = "\\S+", message = "Username cannot contain spaces.")
  String username,

  @NotBlank(message = "Password cannot be blank.")
  @Length(min = 8, message = "Password must be at least 8 characters long.")
  String password
) {
  
  public User toEntity() {
    return User
        .builder()
        .email(this.email)
        .username(this.username)
        .password(this.password)
        .build();
  }
}
