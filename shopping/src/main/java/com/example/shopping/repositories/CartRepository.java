package com.example.shopping.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.models.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

}
