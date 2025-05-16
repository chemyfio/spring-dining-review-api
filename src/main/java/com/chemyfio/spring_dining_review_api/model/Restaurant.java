package com.chemyfio.spring_dining_review_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity()
@Table(name="RESTAURANT")
@Data
public class Restaurant {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name="NAME", unique=true, nullable=false)
  private String name;

  @Column(name="ZIPCODE")
  private String zipcode;

  @Column(name="PEANUT_AVG_SCORE")
  private Float peanutAvgScore = 0.0f;

  @Column(name="EGG_AVG_SCORE")
  private Float eggAvgScore = 0.0f;

  @Column(name="DAIRY_AVG_SCORE")
  private Float dairyAvgScore = 0.0f;

  @Column(name="REVIEW_COUNT")
  private Integer reviewCount;

  @Column(name="TOTAL_AVG_SCORE")
  private Float totalAvgScore;


}
