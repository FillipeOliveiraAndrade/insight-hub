package br.com.fillipeoliveira.insight_hub.modules.user.exceptions;

public class UserNotFoundExcepiton extends RuntimeException {
  public UserNotFoundExcepiton() {
    super("Email ou Senha incorretos");
  }
}
