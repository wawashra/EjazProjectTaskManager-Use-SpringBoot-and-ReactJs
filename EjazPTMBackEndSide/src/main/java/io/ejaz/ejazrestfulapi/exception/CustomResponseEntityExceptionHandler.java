package io.ejaz.ejazrestfulapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdentifireException(ProjectIdentifireException exception , WebRequest request){
        ProjectIdentifierExceptionResponse pIER = new ProjectIdentifierExceptionResponse(exception.getMessage());
        return new ResponseEntity(pIER, HttpStatus.BAD_REQUEST);
    }
}
