package com.training.inno.ms.msorderreactive.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerMSIntegration {

    @Autowired
    private ICustomerIntegration customerIntegration;


    public String addCustomer(CustomerRest customerRestParam){
        return customerIntegration.add(customerRestParam);
    }

    public Mono<CustomerRest> getCustomer(String customerNumber){
        System.out.println("Get customer çağrıldı");
        return customerIntegration.getCustomer(customerNumber);
    }

}
