package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class CompanyEmailAlreadyExistsException extends RuntimeException {
  public CompanyEmailAlreadyExistsException() {
    super("A company with this email address already exists.");
  }
}
