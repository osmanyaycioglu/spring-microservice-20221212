package com.training.inno.ms.customer.services;

import com.training.inno.ms.customer.services.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerManagementService {

    public String add(Customer customerParam){
        return "OK";
    }
}
