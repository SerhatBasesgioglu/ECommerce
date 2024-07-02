package com.aydakar.ecommerce.repository;

import com.aydakar.ecommerce.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
