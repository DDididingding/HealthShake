package com.jhgpt.model.dao;

import java.util.List;
import com.jhgpt.model.dto.Review;

public interface ReviewDao {
	List<Review> selectAllReviews();

	Review selectOneReview(int review_code);

	void insertReview(Review review);

	void deleteReview(int review_code);

	void updateReview(Review review);
	
	List<Review> selectTrainerReviews(int member_code);
}
