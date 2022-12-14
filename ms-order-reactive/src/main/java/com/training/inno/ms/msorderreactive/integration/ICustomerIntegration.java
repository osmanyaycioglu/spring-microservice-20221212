package com.training.inno.ms.msorderreactive.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@FeignClient("customer")
public interface ICustomerIntegration {

    @GetMapping("/api/v1/customer/query/get/by/number")
    Mono<CustomerRest> getCustomer(@RequestParam("cn")  String customerNumber);

    @PostMapping("/api/v1/customer/provision/add")
    String add(@RequestBody CustomerRest customerRestParam);
}
