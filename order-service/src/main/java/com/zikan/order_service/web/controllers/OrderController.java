package com.zikan.order_service.web.controllers;

import com.zikan.order_service.domain.OrderService;
import com.zikan.order_service.domain.models.CreateOrderRequest;
import com.zikan.order_service.domain.models.CreateOrderResponse;
import com.zikan.order_service.domain.models.SecurityService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    private final SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }
    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    CreateOrderResponse createOrder (@Valid @RequestBody CreateOrderRequest request){
        System.out.println("request " + request);
        String userName = securityService.getLoginUserName();
        log.info("Creating order for user: {}", userName);
        return orderService.createOrder(userName, request);
    }
}
