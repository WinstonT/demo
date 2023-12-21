package com.example.products.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.products.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
  List<Product> findByNameContainingIgnoreCase(String name);
}