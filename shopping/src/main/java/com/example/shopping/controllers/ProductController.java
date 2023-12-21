package com.example.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.models.Product;
import com.example.shopping.services.ProductService;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/product/find/all")
  public List<Product> findAllProducts() {
    return productService.findAllProducts();
  }

  @GetMapping("/product/find")
  public List<Product> findProductsByName(
      @RequestParam(value = "query", required = false, defaultValue = "") String query) {
    return productService.findProductsByName(query);
  }

  @PostMapping("/product/add")
  public Product addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }
}
