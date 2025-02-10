package com.zikan.order_service.client.catalog;

import java.math.BigDecimal;

public record Product (
        String code,
        String name,
        String description,
        String imageUUrl,
        BigDecimal price
) {
}
