package br.com.fillipeoliveira.insight_hub.modules.company.exceptions;

public class CompanyNotFoundException extends RuntimeException {
  public CompanyNotFoundException() {
    super("CNPJ ou Senha incorretos");
  }
}
