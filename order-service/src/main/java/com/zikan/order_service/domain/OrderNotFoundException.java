package com.zikan.order_service.domain;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forOrderNumber(int orderNumber) {
        return new OrderNotFoundException("Order number " + orderNumber + " not found");
    }
}
