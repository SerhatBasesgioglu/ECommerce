package com.aydakar.ecommerce.repository;

import com.aydakar.ecommerce.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
