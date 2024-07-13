package com.aydakar.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aydakar.ecommerce.dto.StoreRequestDto;
import com.aydakar.ecommerce.dto.StoreResponseDto;
import com.aydakar.ecommerce.entity.Store;
import com.aydakar.ecommerce.service.StoreService;

@RestController
@RequestMapping("stores")
public class StoreController {
    private final StoreService storeService;
    private final ModelMapper modelMapper;

    public StoreController(StoreService storeService, ModelMapper modelMapper) {
        this.storeService = storeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<StoreResponseDto>> getAllStores(@RequestParam Optional<Long> userId) {
        List<Store> storeList = storeService.getAllStores(userId);
        List<StoreResponseDto> response = storeList.stream()
                .map(store -> modelMapper.map(store, StoreResponseDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<StoreResponseDto> getStoreById(@PathVariable long id) {
        Store store = storeService.getStoreById(id);
        StoreResponseDto response = modelMapper.map(store, StoreResponseDto.class);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @PostMapping("")
    public ResponseEntity<StoreResponseDto> createStore(@RequestBody StoreRequestDto storeRequestDto) {
        Store store = modelMapper.map(storeRequestDto, Store.class);
        Store createdStore = storeService.createStore(store);
        StoreResponseDto response = modelMapper.map(createdStore, StoreResponseDto.class);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    public void deleteStoreById(@PathVariable long id) {
        storeService.deleteStoreById(id);
    }
}
