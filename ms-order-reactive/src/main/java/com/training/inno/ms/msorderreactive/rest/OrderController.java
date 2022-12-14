package com.training.inno.ms.msorderreactive.rest;

import com.training.inno.ms.msorderreactive.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Mono<String> placeOrder(@RequestBody Order orderParam) {
        return orderService.placeOrder(orderParam);
    }

    @GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Order> getAllOrder() {
        return Flux.just(new Order());
    }

    @PostMapping(value = "/get/all")
    public Flux<Order> getAllOrder2() {
        return Flux.just(new Order());
    }


}
