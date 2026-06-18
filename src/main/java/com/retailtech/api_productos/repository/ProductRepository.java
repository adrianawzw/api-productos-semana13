package com.retailtech.api_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retailtech.api_productos.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}