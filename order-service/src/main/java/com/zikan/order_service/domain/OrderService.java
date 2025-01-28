package com.zikan.order_service.domain;

import com.zikan.order_service.domain.models.CreateOrderRequest;
import com.zikan.order_service.domain.models.CreateOrderResponse;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {

    private static final Logger  log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CreateOrderResponse createOrder (String userName, CreateOrderRequest request){
        OrderEntity newOrder = OrderMapper.convertToEntity(request);
        newOrder.setUsername(userName);
        OrderEntity savedOrder = this.orderRepository.save(newOrder);
        log.info("Created Order with orderNumber={}", savedOrder.getOrderNumber());
        return new CreateOrderResponse(savedOrder.getOrderNumber());
    }

}
