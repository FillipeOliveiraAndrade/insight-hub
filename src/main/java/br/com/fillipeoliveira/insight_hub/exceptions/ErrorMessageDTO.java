package br.com.fillipeoliveira.insight_hub.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {

  private String message;
  private String field;
}