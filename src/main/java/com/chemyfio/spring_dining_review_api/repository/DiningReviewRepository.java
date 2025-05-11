package com.chemyfio.spring_dining_review_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chemyfio.spring_dining_review_api.model.DiningReview;
import com.chemyfio.spring_dining_review_api.constant.StatusEnum;


public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
  List<DiningReview> findByStatus(StatusEnum status);
}
