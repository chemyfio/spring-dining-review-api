package com.chemyfio.spring_dining_review_api.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateUserDto {
  private String city;
  private String state;

  @Pattern(regexp="^\\d+$", message = "zipCode must be a string containing number only")
  @Length(min = 6, max = 6)
  private String zipcode;

  private Boolean hasPeanutAllergyInterest = false;

  private Boolean hasEggAllergyInterest = false;

  private Boolean hasDairyAllergyInterest = false;
}
