package com.training.inno.ms.mserrorapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return ErrorObj.builder()
                       .withDesc(exp.getMessage())
                       .withCode(1023)
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {
        return ErrorObj.builder()
                       .withDesc("validasyon problemi")
                       .withCode(2048)
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(be -> ErrorObj.builder()
                                                            .withCode(2049)
                                                            .withDesc(be.toString())
                                                            .build())
                                         .collect(Collectors.toUnmodifiableList()))
                       .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(ConstraintViolationException exp) {
        return ErrorObj.builder()
                       .withDesc("validasyon problemi")
                       .withCode(2048)
                       .withSubErrors(exp.getConstraintViolations()
                                         .stream()
                                         .map(be -> ErrorObj.builder()
                                                            .withCode(2049)
                                                            .withDesc(be.toString())
                                                            .build())
                                         .collect(Collectors.toUnmodifiableList()))
                       .build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(Exception exp) {
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .body(ErrorObj.builder()
                                               .withDesc(exp.getMessage())
                                               .withCode(5000)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.builder()
                                           .withDesc(exp.getMessage())
                                           .withCode(5000)
                                           .build());
    }

}
