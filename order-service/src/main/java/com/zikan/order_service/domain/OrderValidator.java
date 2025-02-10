package com.zikan.order_service.domain;


import com.zikan.order_service.client.catalog.Product;
import com.zikan.order_service.client.catalog.ProductServiceClient;
import com.zikan.order_service.domain.models.CreateOrderRequest;
import com.zikan.order_service.domain.models.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OrderValidator {

    private static final Logger log = LoggerFactory.getLogger(OrderValidator.class);

    private final ProductServiceClient client;

    public OrderValidator(ProductServiceClient client) {
        this.client = client;
    }

    void validate(CreateOrderRequest request) {
        Set<OrderItem> items = request.items();
        for (OrderItem item : items) {
            Product product = client.getProductByCode(item.code())
                    .orElseThrow(()-> new InvalidOrderException("Product with code " + item.code() + " not found"));

            if (item.price().compareTo(product.price()) != 0){
                log.error(
                        "Product price not matching, Actual price:{}, Expected price:{}  ",

                        product.price(), item.price());

                throw new InvalidOrderException("Product Price not matching, Actual price:");
            }
        }













    }
}
