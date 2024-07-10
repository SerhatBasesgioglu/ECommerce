package com.aydakar.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Product;
import com.aydakar.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
