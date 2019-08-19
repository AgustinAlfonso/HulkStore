package com.tangami.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InsufficientAmountException extends UnsupportedOperationException{

    public InsufficientAmountException(String exception) {
        super(exception);
    }

}
