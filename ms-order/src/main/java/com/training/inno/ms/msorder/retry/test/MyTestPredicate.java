package com.training.inno.ms.msorder.retry.test;

import java.util.function.Predicate;

public class MyTestPredicate implements Predicate<String> {
    @Override
    public boolean test(String sParam) {
        if ("fail".equals(sParam)){
            System.out.println("Fail result geldi *****");
            return true;
        }
        return false;
    }
}
