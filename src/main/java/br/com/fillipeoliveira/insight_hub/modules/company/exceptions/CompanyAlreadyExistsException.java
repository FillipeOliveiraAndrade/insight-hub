package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class CompanyAlreadyExistsException extends RuntimeException {
  public CompanyAlreadyExistsException() {
    super("A company with this CNPJ already exists.");
  }
}
