// package com.zikan.order_service.web.controllers;
//
// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.stereotype.Service;
//
// @Service
// public class RabbitMQListener {
//
//    @RabbitListener(queues = "${orders.new-orders-queue}")
//    public void handleNewOrder(MyPayload payload) {
//        System.out.println("New Order: " + payload.getContent());
//    }
//
//    @RabbitListener(queues = "${orders.delivered-orders-queue}")
//    public void handleDeliveredOrder(MyPayload payload) {
//        System.out.println("Delivered Order: " + payload.getContent());
//    }
//
//    public static class MyPayload {
//        private String content;
//
//        public MyPayload() {
//            // Default constructor needed for JSON deserialization
//        }
//
//        public MyPayload(String content) {
//            this.content = content;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//    }
// }
