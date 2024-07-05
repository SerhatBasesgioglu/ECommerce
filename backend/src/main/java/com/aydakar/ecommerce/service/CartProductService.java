package com.aydakar.ecommerce.service;

import com.aydakar.ecommerce.repository.CartProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartProductService {
    private final CartProductRepository cartProductRepository;

    public CartProductService(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }
}
