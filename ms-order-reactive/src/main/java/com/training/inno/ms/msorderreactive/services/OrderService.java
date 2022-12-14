package com.training.inno.ms.msorderreactive.services;

import com.training.inno.ms.msorderreactive.integration.CustomerMSIntegration;
import com.training.inno.ms.msorderreactive.integration.CustomerRest;
import com.training.inno.ms.msorderreactive.integration.RestaurantMSIntegration;
import com.training.inno.ms.msorderreactive.rest.Order;
import com.training.inno.ms.msrestaurantapi.rest.models.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private static Logger                  logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private        RestaurantMSIntegration restaurantMSIntegration;

    @Autowired
    private CustomerMSIntegration customerMSIntegration;

    public Mono<String> placeOrder(Order orderParam) {
        CustomerRest customer = customerMSIntegration.getCustomer(orderParam.getCustomerNumber()).block();
        logger.info("after getCustomer");
        // customer.subscribe(c -> logger.info("Customer added : " + c));
        logger.info("before getMenu");
        return restaurantMSIntegration.getMenu(orderParam)
                                      .map(Menu::getDesc);
    }

}
