package com.zikan.order_service.domain;

import com.zikan.order_service.ApplicationProperties;
import com.zikan.order_service.domain.models.OrderCancelledEvent;
import com.zikan.order_service.domain.models.OrderCreatedEvent;
import com.zikan.order_service.domain.models.OrderDeliveredEvent;
import com.zikan.order_service.domain.models.OrderErrorEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
public class OrderEventPublisher {

//    private static final Logger log = LoggerFactory.getLogger(OrderEventPublisher.class);

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties applicationProperties;


    public OrderEventPublisher(RabbitTemplate rabbitTemplate, ApplicationProperties applicationProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.applicationProperties = applicationProperties;
    }

    public void publish(OrderCreatedEvent event) {
        this.send(applicationProperties.newOrdersQueue(), event);
    }

    public void publish(OrderDeliveredEvent event) {
        this.send(applicationProperties.deliveredOrdersQueue(), event);
    }

    public void publish(OrderCancelledEvent event) {
        this.send(applicationProperties.cancelledOrdersQueue(), event);
    }

    public void publish(OrderErrorEvent event) {
        this.send(applicationProperties.errorOrdersQueue(), event);
    }

    private void send(String routineKey, Object payload) {
        rabbitTemplate.convertAndSend(applicationProperties.orderEventExchange(), routineKey, payload);
    }



















}
