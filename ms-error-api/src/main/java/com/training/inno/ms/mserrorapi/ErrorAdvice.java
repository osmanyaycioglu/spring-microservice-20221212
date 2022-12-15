package com.training.inno.ms.mserrorapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorAdvice {

    @Value("${app.boundedcontext}")
    private String boundedContext;

    @Value("${spring.application.name}")
    private String msName;


    private String getMsFullName() {
        return boundedContext + "." + msName;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return ErrorObj.builder(getMsFullName())
                       .withDesc(exp.getMessage())
                       .withCode(1023)
                       .build();
    }

    @ExceptionHandler(RestClientResponseException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorObj handleException(RestClientResponseException exp) {
        ObjectMapper objectMapper = new ObjectMapper();
        ErrorObj errorObj = null;
        try {
            errorObj = objectMapper.readValue(exp.getResponseBodyAsByteArray(),
                                                       ErrorObj.class);
        } catch (Exception eParam) {
            return ErrorObj.builder(getMsFullName())
                           .withDesc("Entegrasyon problemi . ErrorObj çözülemedi.")
                           .withCode(5002)
                           .build();
        }

        return ErrorObj.builder(getMsFullName())
                       .withDesc("Diğer microservisi çağırırken error oluştu")
                       .withCode(3003)
                       .withSubErrors(Arrays.asList(errorObj))
                       .build();
    }

    @ExceptionHandler(FeignRestClientException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorObj handleException(FeignRestClientException exp) {
        return ErrorObj.builder(getMsFullName())
                       .withDesc("Diğer microservisi çağırırken error oluştu")
                       .withCode(3003)
                       .withSubErrors(Arrays.asList(exp.getErrorObj()))
                       .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {
        return ErrorObj.builder(getMsFullName())
                       .withDesc("validasyon problemi")
                       .withCode(2048)
                       .withSubErrors(exp.getAllErrors()
                                         .stream()
                                         .map(be -> ErrorObj.builder(getMsFullName())
                                                            .withCode(2049)
                                                            .withDesc(be.toString())
                                                            .build())
                                         .collect(Collectors.toUnmodifiableList()))
                       .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(ConstraintViolationException exp) {
        return ErrorObj.builder(getMsFullName())
                       .withDesc("validasyon problemi")
                       .withCode(2048)
                       .withSubErrors(exp.getConstraintViolations()
                                         .stream()
                                         .map(be -> ErrorObj.builder(getMsFullName())
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
                                 .body(ErrorObj.builder(getMsFullName())
                                               .withDesc(exp.getMessage())
                                               .withCode(5000)
                                               .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.builder(getMsFullName())
                                           .withDesc(exp.getMessage())
                                           .withCode(5000)
                                           .build());
    }

}
