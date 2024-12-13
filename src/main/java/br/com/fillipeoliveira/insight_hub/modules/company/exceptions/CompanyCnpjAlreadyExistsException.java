package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class CompanyCnpjAlreadyExistsException extends RuntimeException {
  public CompanyCnpjAlreadyExistsException() {
    super("A company with this CNPJ already exists.");
  }
}
