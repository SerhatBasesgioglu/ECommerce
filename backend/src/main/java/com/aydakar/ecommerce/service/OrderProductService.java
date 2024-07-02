package com.aydakar.ecommerce.service;

import com.aydakar.ecommerce.repository.OrderProductRepository;

public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }
}
