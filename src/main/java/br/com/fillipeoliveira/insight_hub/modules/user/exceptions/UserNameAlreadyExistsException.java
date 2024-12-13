package br.com.fillipeoliveira.insight_hub.modules.user.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {
  public UserNameAlreadyExistsException() {
    super("A user with this name already exists.");
  }
}
