// package com.zikan.order_service.web.controllers;
//
//
// import com.zikan.order_service.ApplicationProperties;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import org.springframework.context.ApplicationEventPublisher;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// public class RabbitMQDemoController {
//    private final RabbitTemplate rabbitTemplate;
//
//    private final ApplicationProperties properties;
//
//    public RabbitMQDemoController(RabbitTemplate rabbitTemplate, ApplicationProperties properties) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.properties = properties;
//    }
//
//    @PostMapping("/send")
//    public void sendMessage (@RequestBody MyMessage message){
//        rabbitTemplate.convertAndSend(
//                properties.orderEventExchange(),
//                message.routingKey(),
//                message.payload());
//
//    }
//
//    record MyMessage (String routingKey, MyPayload payload){ }
//
//    record MyPayload(String content){}
// }
