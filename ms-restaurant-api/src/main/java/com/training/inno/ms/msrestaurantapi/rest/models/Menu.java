package com.training.inno.ms.msrestaurantapi.rest.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Menu {
    private String desc;
    private List<Meal> meals;
}
