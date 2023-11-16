package com.jhgpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jhgpt.model.dto.Review;
import com.jhgpt.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "리뷰 컨트롤러")
public class ReviewRestController {

    @Autowired
    private ReviewService reviewService; // Update to use ReviewService

    // 1. 리뷰 목록 조회
    @GetMapping("/video/{video_id}/reviews")
    @ApiOperation(value = "비디오에 대한 리뷰 조회", notes = "비디오별 리뷰 목록을 가져옵니다.")
    public ResponseEntity<?> listReviews(@PathVariable int video_id) {
        List<Review> list = reviewService.getReviewsForVideo(video_id);
        if (list.size() == 0)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }

    // 2. 리뷰 상세보기
    @GetMapping("/review/{review_id}")
    public ResponseEntity<?> reviewDetail(@PathVariable int review_id) {
        Review review = reviewService.selectReview(review_id);
        if (review == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    // 3. 리뷰 등록
    @PostMapping("/video/{video_id}/review")
    public ResponseEntity<?> writeReview(@PathVariable int video_id, @RequestBody Review review) {
        reviewService.writeReview(review);
        return new ResponseEntity<Review>(review, HttpStatus.CREATED);
    }

    // 4. 리뷰 삭제
    @DeleteMapping("/review/{review_id}")
    public ResponseEntity<Void> deleteReview(@PathVariable int review_id) {
        Review review = reviewService.selectReview(review_id);
        if (review == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        reviewService.deleteReview(review_id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // 5. 리뷰 수정
    @PutMapping("/review")
    public ResponseEntity<Void> updateReview(@RequestBody Review review) {
        Review existingReview = reviewService.selectReview(review.getReview_id());
        if (existingReview == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        reviewService.modifyReview(review);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
