package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class NameAlreadyExistsException extends RuntimeException {
  public NameAlreadyExistsException() {
    super("A company with this name already exists.");
  }
}
