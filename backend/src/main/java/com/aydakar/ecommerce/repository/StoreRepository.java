package com.aydakar.ecommerce.repository;

import java.util.List;

import com.aydakar.ecommerce.entity.Store;

import org.springframework.data.repository.CrudRepository;

import com.aydakar.ecommerce.entity.User;

public interface StoreRepository extends CrudRepository<Store, Long> {
    public List<Store> findByUser(User user);
}
