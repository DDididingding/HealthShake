package com.jhgpt.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.board.model.dto.Review;

@Service
public interface ReviewService {
	
	public List<Review> getReviewList();
	
	public Review selectReview(int review_id);
	
	public void modifyReview(Review review);
	
	public void deleteReview(int review_id);

	public List<Review> getReviewsForVideo(int video_id);

	public void writeReview(Review review);

}
