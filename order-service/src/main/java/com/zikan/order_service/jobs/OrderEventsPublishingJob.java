package com.zikan.order_service.jobs;

import com.zikan.order_service.domain.OrderEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class OrderEventsPublishingJob {

    private static final Logger log = LoggerFactory.getLogger(OrderEventsPublishingJob.class);

    private final OrderEventService orderEventService;

    public OrderEventsPublishingJob(OrderEventService orderEventService) {
        this.orderEventService = orderEventService;
    }

    @Scheduled(cron = "${orders.publish-order-events-job-cron}")
//    @SchedulerLock (name = "publishOrderEvents")
    public void publishOrderEvents() {
        log.info("Publishing order events at {}", Instant.now());
        orderEventService.publishOrderEvents();
    }


















}
