package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
  public EmailAlreadyExistsException() {
    super("A company with this email address already exists.");
  }
}
