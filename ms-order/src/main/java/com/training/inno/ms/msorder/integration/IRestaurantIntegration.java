package com.training.inno.ms.msorder.integration;

import com.training.inno.ms.msrestaurantapi.rest.IRestaurantMenuController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "node-restaurant-api")
public interface IRestaurantIntegration extends IRestaurantMenuController {
}
