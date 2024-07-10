package com.aydakar.ecommerce.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aydakar.ecommerce.service.CartService;

@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

}