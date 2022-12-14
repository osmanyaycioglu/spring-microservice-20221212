package com.training.inno.ms.msorderreactive.integration;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.inno.ms.msorderreactive.rest.Order;
import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import com.training.inno.ms.msrestaurantapi.rest.models.MenuRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RestaurantMSIntegration {

    @Autowired
    private WebClient.Builder wb;

    public Mono<Menu> getMenu(Order orderParam) {
        MenuRequest menuRequest = new MenuRequest();
        menuRequest.setMealNames(orderParam.getMeals());
        Mono<Menu> menuMono = wb.build()
                                .post()
                                .uri("http://restaurant/api/v1/restaurant/menu/get/meals")
                                .body(BodyInserters.fromValue(menuRequest))
                                .retrieve()
                                .bodyToMono(Menu.class);
        return menuMono;
    }

    public void getMenu2(Order orderParam) {
        MenuRequest menuRequest = new MenuRequest();
        menuRequest.setMealNames(orderParam.getMeals());
        wb.build()
          .post()
          .uri("http://restaurant/api/v1/restaurant/menu/get/meals")
          .body(BodyInserters.fromValue(menuRequest))
          .retrieve()
          .bodyToMono(Menu.class)
          .subscribe(m -> System.out.println(m));

    }


}
