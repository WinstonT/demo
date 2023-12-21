package com.example.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.models.Cart;
import com.example.products.services.CartService;

@RestController
public class CartController {

  @Autowired
  private CartService cartService;

  @PostMapping("/cart/find")
  public Cart findCart(@RequestBody String id) {
    return cartService.findCart(id);
  }

  @PostMapping("/cart/add")
  public Cart addCart(@RequestBody Cart cart) {
    return cartService.addCart(cart);
  }
}
