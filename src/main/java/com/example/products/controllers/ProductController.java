package com.example.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.models.Product;
import com.example.products.services.ProductService;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/product/find/all")
  public List<Product> findAllProducts() {
    return productService.findAllProducts();
  }

  @PostMapping("/product/add")
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }
}
