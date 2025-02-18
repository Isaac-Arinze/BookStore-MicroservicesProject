package com.zikan.order_service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "orders")
// @Configuration
public record ApplicationProperties(
        String catalogServiceUrl,
        String orderEventExchange,
        String newOrdersQueue,
        String deliveredOrdersQueue,
        String cancelledOrdersQueue,
        String errorOrdersQueue) {}

//
//    // Getters and Setters
//    public String getOrderEventExchange() {
//        return orderEventExchange;
//    }
//
//    public void setOrderEventExchange(String orderEventExchange) {
//        this.orderEventExchange = orderEventExchange;
//    }
//
//    public String getNewOrdersQueue() {
//        return newOrdersQueue;
//    }
//
//    public void setNewOrdersQueue(String newOrdersQueue) {
//        this.newOrdersQueue = newOrdersQueue;
//    }
//
//    public String getDeliveredOrdersQueue() {
//        return deliveredOrdersQueue;
//    }
//
//    public void setDeliveredOrdersQueue(String deliveredOrdersQueue) {
//        this.deliveredOrdersQueue = deliveredOrdersQueue;
//    }
//
//    public String getCancelledOrdersQueue() {
//        return cancelledOrdersQueue;
//    }
//
//    public void setCancelledOrdersQueue(String cancelledOrdersQueue) {
//        this.cancelledOrdersQueue = cancelledOrdersQueue;
//    }
//
//    public String getErrorOrdersQueue() {
//        return errorOrdersQueue;
//    }
//
//    public void setErrorOrdersQueue(String errorOrdersQueue) {
//        this.errorOrdersQueue = errorOrdersQueue;
//    }
// }
