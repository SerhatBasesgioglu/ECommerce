package com.aydakar.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aydakar.ecommerce.dto.StoreDto;
import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.service.StoreService;

@RestController
@RequestMapping("store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("my-stores")
    public List<Store> getUserStores() {
        return storeService.getUserStores();
    }

    @PostMapping("")
    public Store addStore(@RequestBody StoreDto storeDto) {
        return storeService.addStore(storeDto.getName());
    }
}
