package com.example.shopping.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.models.Cart;
import com.example.shopping.repositories.CartRepository;

@Service
public class CartService {

  @Autowired
  private CartRepository cartRepository;

  public Cart findCart(String id) {
    Optional<Cart> cart = cartRepository.findById(id);
    if (cart.isEmpty()) {
      return null;
    }
    return cart.get();
  }

  public Cart addCart(Cart cart) {
    return cartRepository.save(cart);
  }
}
