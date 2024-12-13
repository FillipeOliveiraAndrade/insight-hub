package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class CompanyNameAlreadyExistsException extends RuntimeException {
  public CompanyNameAlreadyExistsException() {
    super("A company with this name already exists.");
  }
}
