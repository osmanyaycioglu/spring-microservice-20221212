package com.training.inno.ms.msorder.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController {

    @PostMapping("/place")
    public String placeOrder(Order orderParam){

    }
}
