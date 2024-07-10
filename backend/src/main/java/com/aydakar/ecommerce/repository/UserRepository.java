package com.aydakar.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aydakar.ecommerce.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
