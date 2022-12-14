package com.training.inno.ms.msrestaurantapi.rest.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MenuRequest {

    private List<String> mealNames;

}
