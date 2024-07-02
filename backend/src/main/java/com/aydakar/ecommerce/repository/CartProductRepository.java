package com.aydakar.ecommerce.repository;

import com.aydakar.ecommerce.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
}
