package com.jhgpt.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.model.dto.Review;

@Service
public interface ReviewService {

    List<Review> getAllReviews();

    List<Review> getReviewsByMember(int member_code);

    List<Review> getReviewsByWriter(int review_writer);

    Review selectOneReview(int review_code);

    void addReview(Review review);

    void deleteReview(int review_code);

    void updateReview(Review review);

    void likeReview(int review_code);

    void dislikeReview(int review_code);
}
