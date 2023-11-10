package com.jhgpt.board.model.dao;

import java.util.List;

import com.jhgpt.board.model.dto.Review;

public interface ReviewDao {
	
	public List<Review> selectAll();

	// ID에 해당하는 게시글 하나 가져오기
	public Review selectOne(int review_id);

	// 게시글 등록
	public void insertReview(Review review);

	// 게시글 삭제
	public void deleteReview(int review_id);

	// 게시글 수정
	public void updateReview(Review review);

	// 조회수 증가
	public void updateViewCnt(int review_id);

}
