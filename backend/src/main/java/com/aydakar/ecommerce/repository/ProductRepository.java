package com.aydakar.ecommerce.repository;

import com.aydakar.ecommerce.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
