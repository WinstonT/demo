package com.example.products.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.products.models.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

}
