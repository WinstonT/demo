package com.example.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.models.Product;
import com.example.products.repositories.ProductRepository;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  public Product addProduct(Product product) {
    return productRepository.save(product);
  }
}
