package io.ejaz.ejazrestfulapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdentifireException extends RuntimeException{
    public ProjectIdentifireException(String message) {
        super(message);
    }
}
