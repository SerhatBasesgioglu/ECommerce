package com.aydakar.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.entity.User;
import com.aydakar.ecommerce.exception.ResourceNotFoundException;
import com.aydakar.ecommerce.exception.UnauthorizedAccessException;
import com.aydakar.ecommerce.repository.StoreRepository;

@Service
public class StoreService {
    private final StoreRepository storeRepository;
    private final AuthService authService;

    public StoreService(StoreRepository storeRepository, AuthService authService) {
        this.storeRepository = storeRepository;
        this.authService = authService;
    }

    public List<Store> getAllStores(Optional<Long> userId) {
        if (userId.isPresent()) {
            return ((List<Store>) storeRepository.findByUserId(userId.get()));
        }
        return (List<Store>) storeRepository.findAll();
    }

    public Store getStoreById(long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is not a store with this id: " + id));
    }

    public Store createStore(Store store) {
        User user = authService.getCurrentUser();
        store.setUser(user);
        return storeRepository.save(store);
    }

    public void deleteStoreById(long id) {
        storeRepository.deleteById(id);
    }

    public void validateStoreAccess(long storeId) {
        User user = authService.getCurrentUser();
        List<Store> userStores = getAllStores(Optional.of(user.getId()));

        if (userStores.stream().noneMatch(s -> s.getId() == storeId)) {
            throw new UnauthorizedAccessException("Store does not belong to the user");
        }

    }
}
