package com.example.shopping.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.shopping.models.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
  List<Product> findByNameContainingIgnoreCase(String name);

  Optional<Product> findById(String id);
}