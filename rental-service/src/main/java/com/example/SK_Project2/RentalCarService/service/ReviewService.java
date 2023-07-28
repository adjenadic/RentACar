package com.example.SK_Project2.RentalCarService.service;

import com.example.SK_Project2.RentalCarService.dto.review.ReviewCreateDto;
import com.example.SK_Project2.RentalCarService.dto.review.ReviewDto;
import com.example.SK_Project2.RentalCarService.dto.review.ReviewFilterDto;

import java.util.List;

public interface ReviewService {
    ReviewDto findById(Long id);

    List<ReviewDto> findAll();

    ReviewDto addReview(ReviewCreateDto reviewCreateDto);

    Boolean deleteReview(Long id);

    ReviewDto updateReview(ReviewDto reviewDto);

    //--------------//

    List<ReviewDto> filterReview(ReviewFilterDto reviewFilterDto);
}
