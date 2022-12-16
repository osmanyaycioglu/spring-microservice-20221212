package com.training.inno.ms.msorder.rest;

import com.training.inno.ms.msorder.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order/management")
@RefreshScope
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(@RequestBody Order orderParam) {
        return orderService.placeOrder(orderParam);
    }

    @PostMapping("/place2")
    public String placeOrder2(@RequestBody Order orderParam) {
        return orderService.placeOrder2(orderParam);
    }

    @PostMapping("/place3")
    public String placeOrder3(@RequestBody Order orderParam) {
        return orderService.placeOrder3(orderParam);
    }

    @Value("${app.deneme}")
    private String denemeStr;

    @GetMapping("/test")
    public String test() {
        return denemeStr;
    }

}
