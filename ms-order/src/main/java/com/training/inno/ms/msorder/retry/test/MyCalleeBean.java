package com.training.inno.ms.msorder.retry.test;

import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
public class MyCalleeBean {

    private int counter = 0;

    @Retry(name = "xyz")
    public String check(){
        counter++;
        if (counter % 3 == 0){
            throw new IllegalArgumentException("test");
        }
        if (counter % 5 == 0){
            return "fail";
        }
        return "ok";
    }

}
