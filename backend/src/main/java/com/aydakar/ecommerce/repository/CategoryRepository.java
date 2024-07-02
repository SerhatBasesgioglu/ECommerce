package com.aydakar.ecommerce.repository;

import com.aydakar.ecommerce.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
