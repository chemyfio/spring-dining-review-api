package com.chemyfio.spring_dining_review_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USER")
@Data
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "NAME", unique=true, nullable=false)
  private String name;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE")
  private String state;

  @Column(name = "ZIPCODE")
  private String zipcode;

  @Column(name = "HAS_PEANUT_ALLERGY_INTEREST")
  private Boolean hasPeanutAllergyInterest;

  @Column(name = "HAS_EGG_ALLERGY_INTEREST")
  private Boolean hasEggAllergyInterest;
  
  @Column(name = "HAS_DAIRY_ALLERGY_INTEREST")
  private Boolean hasDairyAllergyInterest;
  
}
