package com.training.inno.ms.msorder.integration;

import com.training.inno.ms.msorder.rest.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSNotificationIntegration {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendInitialSMS(Order orderParam) {

        rabbitTemplate.convertAndSend("topic-notification-exchange",
                                      "msg.sms.order.initial",
                                      NotificationMessage.builder()
                                                         .msg("siparişiniz başarı ile alındı. En kısa sürede gönderilecek. "
                                                              + orderParam.getOrderId())
                                                         .dest(orderParam.getCustomerNumber())
                                                         .build());
    }

    public void senddeliverySMS(Order orderParam) {

        rabbitTemplate.convertAndSend("topic-notification-exchange",
                                      "msg.sms.order.delivery",
                                      NotificationMessage.builder()
                                                         .msg("siparişiniz yola çıktı. "
                                                              + orderParam.getOrderId())
                                                         .dest(orderParam.getCustomerNumber())
                                                         .build());
    }

}
