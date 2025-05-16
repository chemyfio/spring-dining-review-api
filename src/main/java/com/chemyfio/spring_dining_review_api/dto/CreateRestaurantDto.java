package com.chemyfio.spring_dining_review_api.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateRestaurantDto {
  @NotBlank()
  private String name;

  @NotBlank()
  @Pattern(regexp="^\\d+$", message = "zipCode must be a string containing number only")
  @Length(min = 6, max = 6)
  private String zipcode;
}
