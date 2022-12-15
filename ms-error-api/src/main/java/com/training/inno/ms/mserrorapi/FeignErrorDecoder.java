package com.training.inno.ms.mserrorapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class FeignErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String sParam,
                            Response responseParam) {
        ObjectMapper objectMapper = new ObjectMapper();
        ErrorObj errorObj = null;
        try {
            errorObj = objectMapper.readValue(responseParam.body()
                                                           .asInputStream(),
                                              ErrorObj.class);
        } catch (Exception eParam) {
            return new FeignRestClientException(ErrorObj.builder("local")
                                                        .withDesc("ErrorObj çözülemedi.")
                                                        .withCode(1009)
                                                        .build());
        }

        return new FeignRestClientException(errorObj);
    }

}
