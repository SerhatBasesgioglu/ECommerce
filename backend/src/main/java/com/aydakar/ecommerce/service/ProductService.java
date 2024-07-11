package com.aydakar.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Product;
import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final AuthService authService;
    private final StoreService storeService;

    public ProductService(ProductRepository productRepository, AuthService authService, StoreService storeService) {
        this.productRepository = productRepository;
        this.authService = authService;
        this.storeService = storeService;
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        User user = authService.getCurrentUser();
        List<Store> userStores = storeService.getStoresByUserId(user.getId());
        product.setStore(userStores.get(0)); // Add parameter for store selection
        return productRepository.save(product);
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }
}
