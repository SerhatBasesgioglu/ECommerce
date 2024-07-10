package com.aydakar.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.repository.StoreRepository;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAllStores() {
        return (List<Store>) storeRepository.findAll();
    }

    public Store getStoreById(long id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public void deleteStoreById(long id) {
        storeRepository.deleteById(id);
    }
}
