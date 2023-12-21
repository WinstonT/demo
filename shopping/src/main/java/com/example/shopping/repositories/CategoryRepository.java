package com.example.shopping.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.shopping.models.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

  Category getCategoryByName(String name);
}
