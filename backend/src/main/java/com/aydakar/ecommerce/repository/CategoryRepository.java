package com.aydakar.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aydakar.ecommerce.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
