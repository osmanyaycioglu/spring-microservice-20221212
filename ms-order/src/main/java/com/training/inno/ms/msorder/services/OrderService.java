package com.training.inno.ms.msorder.services;

import com.training.inno.ms.msorder.integration.CustomerMSIntegration;
import com.training.inno.ms.msorder.integration.CustomerRest;
import com.training.inno.ms.msorder.integration.RestaurantMSIntegration;
import com.training.inno.ms.msorder.rest.Order;
import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private static Logger                  logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private        RestaurantMSIntegration restaurantMSIntegration;

    @Autowired
    private CustomerMSIntegration customerMSIntegration;

    public String placeOrder(Order orderParam) {
        Menu menu = restaurantMSIntegration.getMenu(orderParam);
        return menu.getDesc();
    }

    public String placeOrder2(Order orderParam) {
        Menu menu = restaurantMSIntegration.getMenu2(orderParam);
        return menu.getDesc();
    }

    public String placeOrder3(Order orderParam) {
        logger.info("Order place : " + orderParam);
        CustomerRest customer = customerMSIntegration.getCustomer(orderParam.getCustomerNumber());
        if (customer == null) {
            CustomerRest customerRest = new CustomerRest();
            customerRest.setName(orderParam.getCustomerName());
            customerRest.setSurname(orderParam.getCustomerName());
            customerRest.setHeight(200);
            customerRest.setWeight(100);
            customerRest.setUsername("osmanewjdsgf");
            customerRest.setPassword("dsjkfh23723!DH");
            String s = customerMSIntegration.addCustomer(customerRest);
            logger.info("Customer added : " + s);
        }
        Menu menu = restaurantMSIntegration.getMenu3(orderParam);
        return menu.getDesc();
    }

}
