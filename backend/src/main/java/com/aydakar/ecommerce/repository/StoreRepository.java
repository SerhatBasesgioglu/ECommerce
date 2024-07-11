package com.aydakar.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aydakar.ecommerce.entity.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

    List<Store> getByUserId(long userId);
}
