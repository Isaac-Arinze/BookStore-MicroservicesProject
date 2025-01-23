package com.zikan.order_service.domain.models;

import java.util.Set;
import java.time.LocalDateTime;

public record OrderCreatedEvent(
        String eventId,
        String orderNumber,
        Set<OrderItem> items,
        Customer customer,
        Address deliveryAddress,
        LocalDateTime createdAt) {}
