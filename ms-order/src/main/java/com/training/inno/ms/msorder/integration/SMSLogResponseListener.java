package com.training.inno.ms.msorder.integration;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SMSLogResponseListener {
    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "sms-log-responses", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notification-reponse-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "sms-log-response"))
    public void handleSMS(String reponseMsg) {
        System.out.println(" Received SMS : " + reponseMsg);
    }

}
