package com.zikan.order_service.domain.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record CreateOrderRequest(

        @Valid @NotEmpty (message = "items cannot be empty")
        Set<OrderItem> items,

        @Valid
        Customer customer,

        @Valid
        Address deliveryAddress
) {
}
