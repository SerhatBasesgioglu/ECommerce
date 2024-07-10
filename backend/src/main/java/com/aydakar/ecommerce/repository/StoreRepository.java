package com.aydakar.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aydakar.ecommerce.entity.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

}
