package com.zikan.order_service.jobs;

import com.zikan.order_service.domain.OrderService;
import net.javacrumbs.shedlock.core.LockAssert;
import org.hibernate.query.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class OrderProcessingJob {

    private static final Logger log = LoggerFactory.getLogger(OrderProcessingJob.class);

    private final OrderService orderService;

    public OrderProcessingJob(OrderService orderService) {
        this.orderService = orderService;
    }

    @Scheduled(cron = "${orders.new-order-job-cron}")
//    @SchedulerLock (name = "processNewOrders")
    public void processNewOrders() {
        LockAssert.assertLocked();
        log.info("Processing New Orders at {}", Instant.now());
        orderService.processNewOrders();
    }
}
