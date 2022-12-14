package com.training.inno.ms.msorder.integration;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.inno.ms.msorder.rest.Order;
import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import com.training.inno.ms.msrestaurantapi.rest.models.MenuRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.namespace.QName;
import java.util.List;

@Service
public class RestaurantMSIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private IRestaurantIntegration restaurantIntegration;

    @Retry(name = "restaurant-retry")
    @CircuitBreaker(name = "restaurant-cb", fallbackMethod = "getMenuFallback")
    public Menu getMenu(Order orderParam) {
        MenuRequest menuRequest = new MenuRequest();
        menuRequest.setMealNames(orderParam.getMeals());

        Menu menu = null;
        menu = restTemplate.postForObject("http://node-restaurant-api/api/v1/restaurant/menu/get/meals",
                                          menuRequest,
                                          Menu.class);
        return menu;
    }

    public Menu getMenuFallback(Order orderParam,
                                Throwable throwableParam) {
        return null;
    }

    public Menu getMenu3(Order orderParam) {
        MenuRequest menuRequest = new MenuRequest();
        menuRequest.setMealNames(orderParam.getMeals());
        return restaurantIntegration.getMeals(menuRequest);
    }

    private long counter = 0;

    public Menu getMenu2(Order orderParam) {
        counter++;
        MenuRequest menuRequest = new MenuRequest();
        menuRequest.setMealNames(orderParam.getMeals());
        Application restaurant = eurekaClient.getApplication("restaurant");
        List<InstanceInfo> instances = restaurant.getInstances();
        InstanceInfo instanceInfo = instances.get((int) (counter % instances.size()));

        RestTemplate restTemplate1 = new RestTemplate();
        Menu menu = restTemplate1.postForObject("http://"
                                                + instanceInfo.getIPAddr()
                                                + ":"
                                                + instanceInfo.getPort()
                                                + "/api/v1/restaurant/menu/get/meals",
                                                menuRequest,
                                                Menu.class);
        return menu;
    }

}
