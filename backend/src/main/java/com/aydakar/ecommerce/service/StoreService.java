package com.aydakar.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.repository.StoreRepository;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final AuthService authService;

    public StoreService(StoreRepository storeRepository, AuthService authService) {
        this.storeRepository = storeRepository;
        this.authService = authService;
    }

    public List<Store> getAllStores() {
        return (List<Store>) storeRepository.findAll();
    }

    public List<Store> getUserStores() {
        User user = authService.getCurrentUser();
        return (List<Store>) storeRepository.findByUser(user);
    }

    public Store addStore(String storeName) {
        User user = authService.getCurrentUser();
        Store store = new Store();
        store.setName(storeName);
        store.setUser(user);
        return storeRepository.save(store);
    }
}
