package com.training.inno.ms.msorder.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerMSIntegration {

    @Autowired
    private ICustomerIntegration customerIntegration;


    public String addCustomer(CustomerRest customerRestParam){
        return customerIntegration.add(customerRestParam);
    }

    public CustomerRest getCustomer(String customerNumber){
        return customerIntegration.getCustomer(customerNumber);
    }

}
