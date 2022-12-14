package com.training.inno.ms.msrestaurant.rest;

import com.training.inno.ms.msrestaurantapi.rest.IRestaurantMenuController;
import com.training.inno.ms.msrestaurantapi.rest.models.Meal;
import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import com.training.inno.ms.msrestaurantapi.rest.models.MenuRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantMenuController implements IRestaurantMenuController {

    @Value("${server.port}")
    private int port;

    @Override
    public Menu getMeals(MenuRequest menuRequestParam) {
        Menu menu = new Menu();
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal("lahmacun", 35D));
        meals.add(new Meal("kebap", 100D));
        menu.setMeals(meals);
        menu.setDesc("Port : " + port);
        return menu;
    }

}
