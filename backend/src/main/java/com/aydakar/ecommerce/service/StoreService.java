package com.aydakar.ecommerce.service;

import com.aydakar.ecommerce.repository.StoreRepository;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

}
