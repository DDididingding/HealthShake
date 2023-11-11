package com.jhgpt.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhgpt.board.model.dao.ReviewDao;
import com.jhgpt.board.model.dto.Board;
import com.jhgpt.board.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public List<Review> getReviewList() {
        return reviewDao.selectAll();
    }

    @Override
    public Review selectReview(int review_id) {
        // Update view count and then retrieve the review
        return reviewDao.selectOne(review_id);
    }

    @Transactional
    @Override
    public void modifyReview(Review review) {
        reviewDao.updateReview(review);
    }

    @Override
    public void deleteReview(int review_id) {
        reviewDao.deleteReview(review_id);
    }

	@Override
	public List<Review> getReviewsForVideo(int video_id) {
		// TODO Auto-generated method stub
		return reviewDao.selectReviewsForVideo(video_id);
	}

	@Override
	public void writeReview(Review review) {
	    reviewDao.insertReview(review);
	}

}

	