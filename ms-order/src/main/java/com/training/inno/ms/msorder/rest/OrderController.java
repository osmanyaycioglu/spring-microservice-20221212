package com.training.inno.ms.msorder.rest;

import com.training.inno.ms.msorder.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(@RequestBody Order orderParam){
        return orderService.placeOrder(orderParam);
    }

    @PostMapping("/place2")
    public String placeOrder2(@RequestBody Order orderParam){
        return orderService.placeOrder2(orderParam);
    }

    @PostMapping("/place3")
    public String placeOrder3(@RequestBody Order orderParam){
        return orderService.placeOrder3(orderParam);
    }

}
