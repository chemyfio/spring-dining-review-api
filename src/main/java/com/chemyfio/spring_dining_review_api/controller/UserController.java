package com.chemyfio.spring_dining_review_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.chemyfio.spring_dining_review_api.dto.CreateUserDto;
import com.chemyfio.spring_dining_review_api.dto.UpdateUserDto;
import com.chemyfio.spring_dining_review_api.model.User;
import com.chemyfio.spring_dining_review_api.repository.UserRepository;

import jakarta.validation.Valid;

import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/users")
public class UserController {
  private final UserRepository userRepository;

  public UserController(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping()
  public User createUser(@Valid @RequestBody CreateUserDto createUserReq) {
      Optional<User> existingUserOpt = this.userRepository.findFirstByName(createUserReq.getName());

      if(existingUserOpt.isPresent()) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, "User with requested name has existed!");
      }

      User newUser = new User();
      newUser.setName(createUserReq.getName());
      newUser.setCity(createUserReq.getCity());
      newUser.setState(createUserReq.getState());
      newUser.setZipcode(createUserReq.getZipcode());
      newUser.setHasPeanutAllergyInterest(createUserReq.getHasPeanutAllergyInterest());
      newUser.setHasEggAllergyInterest(createUserReq.getHasEggAllergyInterest());
      newUser.setHasDairyAllergyInterest(createUserReq.getHasDairyAllergyInterest());

      return this.userRepository.save(newUser);
  }
  
  @PutMapping("/{name}")
  public User updateUser(@PathVariable String name, @RequestBody UpdateUserDto updateUserReq) {
    Optional<User> existingUserOpt = this.userRepository.findFirstByName(name);

    if(!existingUserOpt.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with requested name is not found!");
    }

    User userToBeUpdated = existingUserOpt.get();
    
    if(Objects.nonNull(updateUserReq.getCity())) {
      userToBeUpdated.setCity(updateUserReq.getCity());
    }

    if(Objects.nonNull(updateUserReq.getState())) {
      userToBeUpdated.setState(updateUserReq.getState());
    }

    if(Objects.nonNull(updateUserReq.getZipcode())) {
      userToBeUpdated.setZipcode(updateUserReq.getZipcode());
    }

    if(Objects.nonNull(updateUserReq.getHasPeanutAllergyInterest())) {
      userToBeUpdated.setHasPeanutAllergyInterest(updateUserReq.getHasPeanutAllergyInterest());
    }

    if(Objects.nonNull(updateUserReq.getHasEggAllergyInterest())) {
      userToBeUpdated.setHasEggAllergyInterest(updateUserReq.getHasEggAllergyInterest());
    }

    if(Objects.nonNull(updateUserReq.getHasDairyAllergyInterest())) {
      userToBeUpdated.setHasDairyAllergyInterest(updateUserReq.getHasDairyAllergyInterest());
    }

    return this.userRepository.save(userToBeUpdated);
  }

  @GetMapping("/{name}")
  public User getMethodName(@RequestParam String name) {
    Optional<User> existingUserOpt = this.userRepository.findFirstByName(name);

    if(!existingUserOpt.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with requested name is not found!");
    }

    return existingUserOpt.get();
  }
  
}
