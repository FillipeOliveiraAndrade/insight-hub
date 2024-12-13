package br.com.fillipeoliveira.insight_hub.modules.user.exceptions;

public class UserEmailAlreadyExistsException extends RuntimeException {
  public UserEmailAlreadyExistsException() {
    super("A user with this email address already exists.");
  }
}
