package com.training.inno.ms.customer;

import com.training.inno.ms.mserrorapi.ErrorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@SpringBootApplication(scanBasePackages = {"com.training.inno.ms.customer","com.training.inno.ms.mserrorapi"})
@SpringBootApplication
@Import(ErrorConfig.class)
public class MsCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomerApplication.class,
                              args);
    }

}
