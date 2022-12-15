package com.training.inno.ms.msorder.health;

import com.training.inno.ms.mserrorapi.ErrorObj;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up()
                     .withDetail("Error",
                                 ErrorObj.builder("test")
                                         .withDesc("deneme error")
                                         .withCode(6000)
                                         .build())
                     .build();
    }
}
