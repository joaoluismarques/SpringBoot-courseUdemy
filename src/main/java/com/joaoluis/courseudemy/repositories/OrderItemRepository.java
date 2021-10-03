package com.joaoluis.courseudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoluis.courseudemy.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
