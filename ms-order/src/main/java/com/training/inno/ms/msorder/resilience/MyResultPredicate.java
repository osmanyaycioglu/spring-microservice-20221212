package com.training.inno.ms.msorder.resilience;


import com.training.inno.ms.msrestaurantapi.rest.models.Menu;

import java.util.function.Predicate;

public class MyResultPredicate implements Predicate<Menu> {
    @Override
    public boolean test(Menu menuParam) {
        if (menuParam != null){
            if (menuParam.getMeals() == null){
                return true;
            }
        }
        return false;
    }
}
