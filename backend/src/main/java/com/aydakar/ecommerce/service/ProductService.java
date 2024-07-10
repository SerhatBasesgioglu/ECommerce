package com.aydakar.ecommerce.service;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
