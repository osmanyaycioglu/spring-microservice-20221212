package com.training.inno.ms.noderestaurantapigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NodeRestaurantApigwApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeRestaurantApigwApplication.class,
                              args);
    }

}
