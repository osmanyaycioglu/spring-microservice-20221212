package com.training.inno.ms.msrestaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsRestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRestaurantApplication.class,
                              args);
    }

}
