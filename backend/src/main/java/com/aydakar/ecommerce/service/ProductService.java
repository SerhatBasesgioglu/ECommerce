package com.aydakar.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Product;
import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.exception.ResourceNotFoundException;
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
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is not a product with this id " + id));
    }

    public Product createProduct(Product product, long storeId) {
        Store store = storeService.getStoreById(storeId);
        storeService.validateStoreAccess(storeId);
        product.setStore(store);
        return productRepository.save(product);
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

}
