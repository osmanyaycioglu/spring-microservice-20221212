package com.training.inno.ms.msorderreactive.integration;

import com.training.inno.ms.msrestaurantapi.rest.IRestaurantMenuController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "restaurant")
public interface IRestaurantIntegration extends IRestaurantMenuController {
}
