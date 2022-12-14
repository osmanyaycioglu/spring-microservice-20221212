package com.training.inno.ms.msorderreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class MsOrderReactiveApplication {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadbalancedWebClient(){
        return WebClient.builder();
    }

    public static void main(String[] args) {
        SpringApplication.run(MsOrderReactiveApplication.class,
                              args);
    }

}
