package com.aydakar.ecommerce.service;

import com.aydakar.ecommerce.repository.CartRepository;

public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

}
