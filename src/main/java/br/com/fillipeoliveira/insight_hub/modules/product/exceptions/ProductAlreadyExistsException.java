package br.com.fillipeoliveira.insight_hub.modules.product.exceptions;

public class ProductAlreadyExistsException extends RuntimeException {
  public ProductAlreadyExistsException() {
    super("Você já adicionou esse produto");
  }
}
