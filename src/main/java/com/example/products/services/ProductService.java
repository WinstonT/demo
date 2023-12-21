package com.example.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.models.Category;
import com.example.products.models.Product;
import com.example.products.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryService categoryService;

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  public List<Product> findProductsByName(String name) {
    return productRepository.findByNameContainingIgnoreCase(name);
  }

  public Product addProduct(Product product) {
    if (validateProduct(product)) {
      return productRepository.save(product);
    }
    return null;
  }

  private boolean validateProduct(Product product) {
    if (product.getName().isBlank()) {
      return false;
    }

    if (product.getDescription().isBlank()) {
      return false;
    }

    if (product.getImage().isBlank() || !product.getImage().matches("([^\\\\s]+(\\\\.(?i)(jpe?g|png|gif|bmp))$)")) {
      return false;
    }

    if (product.getStock() <= 0) {
      return false;
    }

    if (product.getPrice() <= 0) {
      return false;
    }

    Category category = categoryService.findCategory(product.getCategory().getName());
    if (category == null) {
      return false;
    }

    return true;
  }
}
