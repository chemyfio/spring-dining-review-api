package com.chemyfio.spring_dining_review_api.model;

import com.chemyfio.spring_dining_review_api.constant.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "DINING_REVIEW")
@Data
public class DiningReview {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "RESTAURANT_ID")
  private Long restaurantId;

  @Column(name = "PEANUT_SCORE")
  private Integer peanutScore;

  @Column(name = "EGG_SCORE")
  private Integer eggScore;

  @Column(name = "DAIRY_SCORE")
  private Integer dairyScore;

  @Column(name = "COMMENTARY")
  private String commentary;

  @Column(name= "STATUS")
  private StatusEnum status;
}
