package com.example.shopping.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.models.Category;
import com.example.shopping.models.Product;
import com.example.shopping.models.Variant;
import com.example.shopping.repositories.ProductRepository;
import com.example.shopping.utils.Util;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private VariantService variantService;

  public List<Product> findAllProducts() {
    return productRepository.findAll();
  }

  public List<Product> findProductsByName(String name) {
    return productRepository.findByNameContainingIgnoreCase(name);
  }

  public Product findProductById(String id) {
    Optional<Product> product = productRepository.findById(id);
    if (product.isEmpty()) {
      return null;
    }
    return product.get();
  }

  public Product addProduct(Product product) {
    if (validateProduct(product)) {
      return productRepository.save(product);
    }
    return null;
  }

  private boolean validateProduct(Product product) {
    if (!Util.validString(product.getName())) {
      return false;
    }

    if (!Util.validString(product.getDescription())) {
      return false;
    }

    if (!Util.validString(product.getImage())) {
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

    if (product.getVariants() == null) {
      product.setVariants(new ArrayList<Variant>());
    } else {
      // TODO: create bulk save for variants
      for (Variant variant : product.getVariants()) {
        variantService.addVariant(variant, product.getImage());
      }
    }

    return true;
  }
}
