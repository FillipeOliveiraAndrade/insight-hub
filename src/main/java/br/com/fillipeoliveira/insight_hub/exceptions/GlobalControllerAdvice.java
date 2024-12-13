package br.com.fillipeoliveira.insight_hub.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyCnpjAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyEmailAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.company.exceptions.CompanyNameAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.user.exceptions.UserEmailAlreadyExistsException;
import br.com.fillipeoliveira.insight_hub.modules.user.exceptions.UserNameAlreadyExistsException;

@ControllerAdvice
public class GlobalControllerAdvice {
  
  private MessageSource messageSource;

  public GlobalControllerAdvice(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(
    MethodArgumentNotValidException e) {
    List<ErrorMessageDTO> dto = new ArrayList<>();

    e.getBindingResult().getFieldErrors().forEach(err -> {
      String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
      ErrorMessageDTO error = new ErrorMessageDTO(message, err.getField());
      dto.add(error);
    });

    return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({
    CompanyCnpjAlreadyExistsException.class,
    CompanyNameAlreadyExistsException.class,
    CompanyEmailAlreadyExistsException.class,
    UserNameAlreadyExistsException.class,
    UserEmailAlreadyExistsException.class
  })
  public ResponseEntity<ErrorMessageDTO> handleCompanyBadRequestException(RuntimeException exception) {
    ErrorMessageDTO error = new ErrorMessageDTO(exception.getMessage(), null);

    return ResponseEntity.badRequest().body(error);
  }
}
