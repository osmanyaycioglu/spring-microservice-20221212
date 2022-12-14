package com.training.inno.ms.msorder.rest;

import java.util.List;

public class Order {
    private String customerName;
    private String customerNumber;
    private String orderId;
    private List<String> meals;
    private Long deliveryTime;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerNameParam) {
        customerName = customerNameParam;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderIdParam) {
        orderId = orderIdParam;
    }

    public List<String> getMeals() {
        return meals;
    }

    public void setMeals(List<String> mealsParam) {
        meals = mealsParam;
    }

    public Long getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Long deliveryTimeParam) {
        deliveryTime = deliveryTimeParam;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumberParam) {
        customerNumber = customerNumberParam;
    }

    @Override
    public String toString() {
        return "Order{" +
               "customerName='" + customerName + '\'' +
               ", customerNumber='" + customerNumber + '\'' +
               ", orderId='" + orderId + '\'' +
               ", meals=" + meals +
               ", deliveryTime=" + deliveryTime +
               '}';
    }
}
