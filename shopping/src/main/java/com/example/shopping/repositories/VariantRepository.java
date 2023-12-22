package com.example.shopping.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.models.Variant;

@Repository
public interface VariantRepository extends MongoRepository<Variant, String> {

}
