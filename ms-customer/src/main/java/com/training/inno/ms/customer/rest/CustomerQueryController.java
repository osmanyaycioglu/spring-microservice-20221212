package com.training.inno.ms.customer.rest;

import com.training.inno.ms.customer.rest.models.CustomerRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {

    @GetMapping("/get/by/number")
    public CustomerRest getCustomerByNumber(@RequestParam("cn")  String customerNumber){
        return null;
    }

}
