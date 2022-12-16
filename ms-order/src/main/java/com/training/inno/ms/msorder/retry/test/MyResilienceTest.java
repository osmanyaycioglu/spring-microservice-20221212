package com.training.inno.ms.msorder.retry.test;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class MyResilienceTest implements CommandLineRunner {

    @Autowired
    private RetryRegistry retryRegistry;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Autowired
    private MyCallerBean myCallerBean;

    @Override
    public void run(String... args) throws Exception {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("restaurant-cb");
        CircuitBreaker.Metrics metrics = circuitBreaker.getMetrics();
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(500);
                myCallerBean.test1();
                CBMetric cbMetric = new CBMetric(metrics);
                System.out.println("index:" + i + " state:[" + circuitBreaker.getState() + "]" + cbMetric);
            } catch (Exception eParam) {
                System.out.println(eParam.getClass().getSimpleName() + " Exception aldım : " + eParam.getMessage());
                CBMetric cbMetric = new CBMetric(metrics);
                System.out.println("index:" + i + " state:[" + circuitBreaker.getState() + "]" + cbMetric);
            }
        }
    }

    public void run2(String... args) throws Exception {
        Retry xyz = retryRegistry.retry("xyz");
        Retry.Metrics metrics = xyz.getMetrics();
        xyz.getEventPublisher()
           .onRetry(event -> System.out.println("Retry count : " + event.getNumberOfRetryAttempts()));
        for (int i = 0; i < 20; i++) {

            try {
                myCallerBean.test1();
                System.out.println("n : "
                                   + metrics.getNumberOfSuccessfulCallsWithoutRetryAttempt()
                                   + " r: "
                                   + metrics.getNumberOfSuccessfulCallsWithRetryAttempt()
                                   + " e: "
                                   + metrics.getNumberOfFailedCallsWithRetryAttempt());
            } catch (Exception eParam) {
                System.out.println("Exception aldım : " + eParam.getMessage());
                System.out.println("n : "
                                   + metrics.getNumberOfSuccessfulCallsWithoutRetryAttempt()
                                   + " r: "
                                   + metrics.getNumberOfSuccessfulCallsWithRetryAttempt()
                                   + " e: "
                                   + metrics.getNumberOfFailedCallsWithRetryAttempt());
            }
        }
    }

}
