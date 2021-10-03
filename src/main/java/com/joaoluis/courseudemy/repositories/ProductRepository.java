package com.joaoluis.courseudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoluis.courseudemy.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
