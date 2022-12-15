package com.training.inno.ms.msorder.retry.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCallerBean {

    @Autowired
    private MyCalleeBean myCalleeBean;


    public void test1() {
        myCalleeBean.check();
    }
}
