package org.khalin.jpa_basic.repository;

import org.khalin.jpa_basic.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
