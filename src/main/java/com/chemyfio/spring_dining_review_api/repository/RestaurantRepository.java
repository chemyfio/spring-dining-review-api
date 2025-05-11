package com.chemyfio.spring_dining_review_api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.chemyfio.spring_dining_review_api.model.Restaurant;
import java.util.List;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
  Optional<Restaurant> findFirstByNameAndZipcode(String name, String zipcode);
  List<Restaurant> findByZipcodeAndReviewCountGreaterThanOrderByNameDesc(String zipcode, Integer reviewCount);
}
