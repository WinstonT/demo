package com.example.shopping.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.models.Cart;
import com.example.shopping.models.Product;
import com.example.shopping.models.Variant;
import com.example.shopping.repositories.CartRepository;

@Service
public class CartService {

  @Autowired
  private CartRepository cartRepository;

  @Autowired
  private ProductService productService;

  public Cart findCart(String id) {
    Optional<Cart> cart = cartRepository.findById(id);
    if (cart.isEmpty()) {
      return null;
    }
    return cart.get();
  }

  public Cart addCart(Cart cart) {
    Product product = productService.findProductById(cart.getProductId());

    if (product == null) {
      return null;
    }

    List<String> variants = product.getVariants().stream().map(Variant::getName).collect(Collectors.toList());
    if (!variants.contains(cart.getSelectedProductVariant())) {
      return null;
    }

    return cartRepository.save(cart);
  }
}
