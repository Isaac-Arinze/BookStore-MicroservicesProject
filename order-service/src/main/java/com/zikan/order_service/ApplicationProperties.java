package com.zikan.order_service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "orders")
@Configuration
public class ApplicationProperties {
    private String orderEventExchange;
    private String newOrdersQueue;
    private String deliveredOrdersQueue;
    private String cancelledOrdersQueue;
    private String errorOrdersQueue;

    // Getters and Setters
    public String getOrderEventExchange() {
        return orderEventExchange;
    }

    public void setOrderEventExchange(String orderEventExchange) {
        this.orderEventExchange = orderEventExchange;
    }

    public String getNewOrdersQueue() {
        return newOrdersQueue;
    }

    public void setNewOrdersQueue(String newOrdersQueue) {
        this.newOrdersQueue = newOrdersQueue;
    }

    public String getDeliveredOrdersQueue() {
        return deliveredOrdersQueue;
    }

    public void setDeliveredOrdersQueue(String deliveredOrdersQueue) {
        this.deliveredOrdersQueue = deliveredOrdersQueue;
    }

    public String getCancelledOrdersQueue() {
        return cancelledOrdersQueue;
    }

    public void setCancelledOrdersQueue(String cancelledOrdersQueue) {
        this.cancelledOrdersQueue = cancelledOrdersQueue;
    }

    public String getErrorOrdersQueue() {
        return errorOrdersQueue;
    }

    public void setErrorOrdersQueue(String errorOrdersQueue) {
        this.errorOrdersQueue = errorOrdersQueue;
    }
}
