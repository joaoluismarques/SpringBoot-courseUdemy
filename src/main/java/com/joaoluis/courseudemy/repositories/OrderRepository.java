package com.joaoluis.courseudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoluis.courseudemy.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
