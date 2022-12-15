package com.training.inno.ms.msorder.resilience;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.inno.ms.mserrorapi.ErrorObj;
import com.training.inno.ms.mserrorapi.FeignRestClientException;
import org.springframework.web.client.RestClientResponseException;

import java.io.IOException;
import java.util.function.Predicate;

public class MyRetryChooser implements Predicate<Throwable> {

    @Override
    public boolean test(Throwable throwableParam) {
        if (throwableParam instanceof FeignRestClientException) {
            FeignRestClientException frc = (FeignRestClientException) throwableParam;
            ErrorObj errorObj = frc.getErrorObj();
            if (errorObj != null) {
                return checkErrorObj(errorObj);
            }
        } else if (throwableParam instanceof RestClientResponseException) {
            RestClientResponseException exception = (RestClientResponseException) throwableParam;
            exception.getResponseBodyAsByteArray();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                ErrorObj errorObj = objectMapper.readValue(exception.getResponseBodyAsByteArray(),
                                                           ErrorObj.class);
                return checkErrorObj(errorObj);
            } catch (Exception eParam) {
                return false;
            }
        } else if (throwableParam instanceof NullPointerException){
            return false;
        }
        return false;
    }

    private static boolean checkErrorObj(ErrorObj errorObj) {
        int code = errorObj.getCode();
        switch (code) {
            case 1024:
            case 1335:
            case 1800:
                return true;
            default:
                return false;
        }
    }

}
