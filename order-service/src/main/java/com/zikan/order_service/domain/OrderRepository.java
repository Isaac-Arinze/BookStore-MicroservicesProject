package com.zikan.order_service.domain;

import com.zikan.order_service.domain.models.OrderStatus;
import com.zikan.order_service.domain.models.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByStatus(OrderStatus status);

    Optional<OrderEntity> findByOrderNumber (String orderNumber);

    default void updateOrderStatus(String orderNumber, OrderStatus status) {
        OrderEntity order = this.findByOrderNumber(orderNumber).orElseThrow();
        order.setStatus(status);
        this.save(order);
    }
    @Query("""
select new com.zikan.order_service.domain.models.OrderSummary(o.orderNumber, o.status) 
from OrderEntity o
where o.username = :userName
""")

    List<OrderSummary> findByUserName(String userName);
}
