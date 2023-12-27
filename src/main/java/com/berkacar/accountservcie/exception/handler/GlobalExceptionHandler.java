package com.berkacar.accountservcie.exception.handler;

import com.berkacar.accountservcie.exception.exceptions.InvalidAuthException;
import com.berkacar.accountservcie.exception.exceptions.MissingParameterException;
import com.berkacar.accountservcie.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAuthException.class)
    public ExceptionResponse handleInvalidAuthException(InvalidAuthException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.UNAUTHORIZED)
                .errorMessage("UNAUTHORIZED")
                .description("there is no auth")
                .dateTime(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingParameterException.class)
    public ExceptionResponse handleMissingParameterException(MissingParameterException exception) {
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .errorMessage("BAD_REQUEST")
                .description("missing parameter")
                .dateTime(LocalDateTime.now())
                .build();
    }
}
