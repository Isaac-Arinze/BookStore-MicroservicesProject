package com.zikan.order_service.domain;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zikan.order_service.domain.models.OrderCreatedEvent;
import com.zikan.order_service.domain.models.OrderEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderEventService {

    private static final Logger log = LoggerFactory.getLogger(OrderEventService.class);

    private final OrderEventRepository orderEventRepository;

    private final OrderEventPublisher orderEventPublisher;

    private final ObjectMapper objectMapper;


    public OrderEventService(OrderEventRepository orderEventRepository, OrderEventPublisher orderEventPublisher, ObjectMapper objectMapper) {
        this.orderEventRepository = orderEventRepository;
        this.orderEventPublisher = orderEventPublisher;
        this.objectMapper = objectMapper;
    }

    void save (OrderCreatedEvent event){

        OrderEventEntity orderEvent = new OrderEventEntity();

        orderEvent.setEventId(event.eventId());
        orderEvent.setOrderNumber(event.orderNumber());
        orderEvent.setEventType(OrderEventType.ORDER_DELIVERED);
        orderEvent.setCreatedAt(event.createdAt());
        orderEvent.setPayload(toJsonPayload(event));
        this.orderEventRepository.save(orderEvent);
    }

    public void publishOrderEvents(){
        Sort sort = Sort.by( "createdAt").ascending();

        List<OrderEventEntity> events = orderEventRepository.findAll(sort);
        log.info("Found {} order events to be published", events.size());
        for (OrderEventEntity event : events) {
            this.publishOrderEvents();
            orderEventRepository.delete(event);
        }
    }



















}
