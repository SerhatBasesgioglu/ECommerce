package com.aydakar.ecommerce.service;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Cart;
import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.repository.CartProductRepository;
import com.aydakar.ecommerce.repository.CartRepository;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    public CartService(CartRepository cartRepository, CartProductRepository cartProductRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    public void createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
    }

}
