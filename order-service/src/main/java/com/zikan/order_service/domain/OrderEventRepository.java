package com.zikan.order_service.domain;

import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEventRepository extends JpaRepository<OrderEventEntity, Long> {
}
