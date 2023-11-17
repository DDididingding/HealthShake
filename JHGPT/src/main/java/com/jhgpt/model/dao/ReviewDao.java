package com.jhgpt.model.dao;

import java.util.List;

import com.jhgpt.model.dto.Review;

public interface ReviewDao {
    
    // 전체 리뷰 목록 가져오기
    List<Review> selectAllReviews();

    // 트레이너를 기준으로 리뷰 목록 가져오기
    List<Review> selectReviewsByMember(int member_code);

    // 작성자를 기준으로 리뷰 목록 가져오기
    List<Review> selectReviewsByWriter(int review_writer); 
       
    // 리뷰 하나 가져오기
    Review selectOneReview(int review_code);

    // 리뷰 등록
    void insertReview(Review review);

    // 리뷰 삭제
    void deleteReview(int review_code);

    // 리뷰 수정
    void updateReview(Review review);
}

