package com.aydakar.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aydakar.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
