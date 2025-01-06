package gov.saanjh.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class InvalidUserTypeException extends RuntimeException{
    public InvalidUserTypeException(String message){super(message);}
}
