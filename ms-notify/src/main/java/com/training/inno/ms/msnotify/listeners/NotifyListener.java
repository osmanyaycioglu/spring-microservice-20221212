package com.training.inno.ms.msnotify.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class NotifyListener {

    @Value("${server.port}")
    private int port;

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "sms-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notification-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "sms-notification"))
    public void handleSMS(NotificationMessage nmsg) {
        System.out.println(port + " Received SMS : " + nmsg);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "email-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notification-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.DIRECT),
            key = "email-notification"))
    public void handleMail(NotificationMessage nmsg) {
        System.out.println(port + " Received EMAIL : " + nmsg);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "topic-sms-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "topic-notification-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "msg.sms.#"))
    public void handleTopicSMS(NotificationMessage nmsg) {
        System.out.println(port + " Received Topic SMS : " + nmsg);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "topic-mail-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "topic-notification-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "msg.mail.#"))
    public void handleTopicMAIL(NotificationMessage nmsg) {
        System.out.println(port + " Received Topic MAIL : " + nmsg);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "topic-all-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "topic-notification-exchange", durable = "true", autoDelete = "false", type = ExchangeTypes.TOPIC),
            key = "msg.#"))
    @SendTo("notification-reponse-exchange/sms-log-response")
    public String handleTopicALL(NotificationMessage nmsg) {
        System.out.println(port + " Received ALL : " + nmsg);
        return "Mesaj : " + nmsg +  " loglaandı.";
    }

}
