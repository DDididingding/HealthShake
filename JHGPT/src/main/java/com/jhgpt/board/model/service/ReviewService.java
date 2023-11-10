package com.jhgpt.board.model.service;

import java.util.List;

import com.jhgpt.board.model.dto.Review;

public interface ReviewService {
	
	List<Review> getReviewList();
	
	void writeReview(Review review);
	
	Review selectReview(int review_id);
	
	void modifyReview(Review review);
	
	void deleteReview(int review_id);

}
