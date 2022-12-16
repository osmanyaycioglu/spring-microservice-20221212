package com.training.inno.ms.msorder.retry.test;

import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
public class MyCalleeBean {

    private int counter = 0;

    // @Retry(name = "xyz",fallbackMethod = "checkFallback")
    @CircuitBreaker(name = "restaurant-cb", fallbackMethod = "checkFallback")
    // @CircuitBreaker(name = "restaurant-cb")
    public String check() {
        counter++;
        if (counter < 20) {
            if (counter % 3 == 0) {
//                try {
//                    Thread.sleep(600);
//                } catch (InterruptedException eParam) {
//
//                }
                throw new IllegalArgumentException("test");
            }
        }
        return "ok";
    }

    public String checkFallback(Throwable throwableParam) {
        System.out.println("Fallback");
        return "fallback";
    }


}
