package com.chemyfio.spring_dining_review_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.chemyfio.spring_dining_review_api.dto.CreateRestaurantDto;
import com.chemyfio.spring_dining_review_api.model.Restaurant;
import com.chemyfio.spring_dining_review_api.repository.RestaurantRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
  private final RestaurantRepository restaurantRepository;

  public RestaurantController(final RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  @PostMapping()
  public Restaurant createRestaurant(@Valid @RequestBody CreateRestaurantDto createRestaurantReq) {
    Optional<Restaurant> existingRestaurantOpt = this.restaurantRepository.findFirstByNameAndZipcode(createRestaurantReq.getName(), createRestaurantReq.getZipcode());  
    
    if(existingRestaurantOpt.isPresent()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "There is a restaurant with existing data registered.");
    } else {
      Restaurant newRestaurant = new Restaurant();
      newRestaurant.setName(createRestaurantReq.getName());
      newRestaurant.setZipcode(createRestaurantReq.getZipcode());
      Restaurant savedRestaurant = this.restaurantRepository.save(newRestaurant);
      return savedRestaurant;
    }
  }

  @GetMapping("/{id}")
  public Restaurant getRestaurantById(@PathVariable Long id) {
    if(Objects.isNull(id)) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Id cannot be empty!");
    }
    Optional<Restaurant> restaurantOpt = this.restaurantRepository.findById(id);
    
    if(restaurantOpt.isPresent()) {
      return restaurantOpt.get();
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found!");
    }
  }
  
  @GetMapping("/{zipCode}/zipCode")
  public List<Restaurant> getRestaurantByZipCode(@PathVariable String zipCode) {
    if(Objects.isNull(zipCode)) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Id cannot be empty!");
    }
    List<Restaurant> restaurants = this.restaurantRepository.findByZipcodeAndReviewCountGreaterThanOrderByNameDesc(zipCode, 1);
    
    return restaurants;
  }
  
}
