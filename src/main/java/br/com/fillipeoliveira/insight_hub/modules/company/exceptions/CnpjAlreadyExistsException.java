package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class CnpjAlreadyExistsException extends RuntimeException {
  public CnpjAlreadyExistsException() {
    super("A company with this CNPJ already exists.");
  }
}
