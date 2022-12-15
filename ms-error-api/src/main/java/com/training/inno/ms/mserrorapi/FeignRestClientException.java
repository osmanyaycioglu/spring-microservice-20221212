package com.training.inno.ms.mserrorapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeignRestClientException extends RuntimeException {
    private ErrorObj errorObj;


}
