package com.training.inno.ms.msrestaurantapi.rest;

import com.training.inno.ms.msrestaurantapi.rest.models.Meal;
import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import com.training.inno.ms.msrestaurantapi.rest.models.MenuRequest;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface IRestaurantMenuController {

    @PostMapping("/api/v1/restaurant/menu/get/meals")
    Menu getMeals(MenuRequest menuRequestParam);

}
