package com.example.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.models.Category;
import com.example.shopping.repositories.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category findCategory(String name) {
    return categoryRepository.getCategoryByName(name);
  }
}
