package com.aydakar.ecommerce.repository;

import com.aydakar.ecommerce.entity.OrderProduct;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
}
