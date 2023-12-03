package com.jhgpt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhgpt.model.dao.ReviewDao;
import com.jhgpt.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
    private ReviewDao reviewDao;

    @Override
    public List<Review> getAllReviews() {
        return reviewDao.selectAllReviews();
    }

    @Override
    public List<Review> getReviewsByMember(int member_code) {
        return reviewDao.selectReviewsByMember(member_code);
    }

    @Override
    public List<Review> getReviewsByWriter(int writer_code) {
        return reviewDao.selectReviewsByWriter(writer_code);
    }

    @Override
    public Review selectOneReview(int review_code) {
        return reviewDao.selectOneReview(review_code);
    }


    @Override
    public void addReview(Review review) {
        reviewDao.insertReview(review);
    }

    @Override
    public void deleteReview(int review_code) {
        reviewDao.deleteReview(review_code);
    }

    @Override
    public void updateReview(Review review) {
        reviewDao.updateReview(review);
    }

    @Override
    public void likeReview(int review_code) {
        reviewDao.likeReview(review_code);
    }

    @Override
    public void dislikeReview(int review_code) {
        reviewDao.dislikeReview(review_code);
    }

    
}
