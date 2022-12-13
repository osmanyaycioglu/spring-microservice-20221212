package com.training.inno.ms.customer.rest;

import com.training.inno.ms.customer.rest.models.CustomerRest;

public class CustomerDataManagementController {

    public String update(CustomerRest customerParam){
        return "OK";
    }

    public String purge(Long customerId){
        return "OK";
    }

}
