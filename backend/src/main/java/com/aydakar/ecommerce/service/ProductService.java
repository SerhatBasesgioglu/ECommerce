package com.aydakar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Category;
import com.aydakar.ecommerce.entity.Product;
import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.exception.ResourceNotFoundException;
import com.aydakar.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final StoreService storeService;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, StoreService storeService,
            CategoryService categoryService) {
        this.productRepository = productRepository;
        this.storeService = storeService;
        this.categoryService = categoryService;
    }

    public List<Product> getAllProducts(Optional<Long> storeId) {
        if (storeId.isPresent()) {
            return (List<Product>) productRepository.findByStoreId(storeId.get());
        }
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is not a product with this id " + id));
    }

    public Product createProduct(Product product) {
        String storeName = (product.getStore() != null) ? product.getStore().getName() : null;
        String categoryName = (product.getCategory() != null) ? product.getCategory().getName() : null;
        Store store = storeService.getStoreByName(storeName);
        Category category = categoryService.getCategoryByName(categoryName);
        storeService.validateStoreAccess(store.getId());
        categoryService.validateCategory(category.getId());
        product.setStore(store);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

}
