package com.example.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.models.Category;
import com.example.products.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category findCategory(String name) {
    return categoryRepository.getCategoryByName(name);
  }
}
