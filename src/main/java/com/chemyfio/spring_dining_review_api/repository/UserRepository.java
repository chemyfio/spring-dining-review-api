package com.chemyfio.spring_dining_review_api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chemyfio.spring_dining_review_api.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
  Optional<User> findFirstByName(String name);
}
