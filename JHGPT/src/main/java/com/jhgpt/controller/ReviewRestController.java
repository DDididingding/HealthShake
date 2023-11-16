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

    // 1. 트레이너별 리뷰 목록 조회
    @GetMapping("/trainer/{member_code}/review")
    public ResponseEntity<?> reviewListByTrainer(@PathVariable int member_code) {
        List<Review> list = reviewService.getReviewsByMember(member_code);
        if (list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }
    //멤버가 쓴 리뷰 모아보기
    @GetMapping("/review/{review_writer}")
    public ResponseEntity<?> reviewListByWriter(@PathVariable int review_writer) {
        List<Review> list = reviewService.getReviewsByWriter(review_writer);
        if (list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }


    // 리뷰 상세보기
    @GetMapping("/review/{review_code}")
    public ResponseEntity<?> reviewDetail(@PathVariable int review_code) {
        Review review = reviewService.selectOneReview(review_code);
        if (review == null)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }


    // 3. 트레이너에 대한 리뷰 등록
    // 리뷰는 냅다 등록하고, 보여줄 때만 트레이너에 대한 리뷰만 보여주기
    @PostMapping("/review")
    @ApiOperation(value = "리뷰 등록", notes = "리뷰 등록")
    public ResponseEntity<?> addReview(@RequestBody Review review) {
        reviewService.addReview(review);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    // 4. 리뷰 삭제
    @DeleteMapping("/review/{review_code}")
    @ApiOperation(value = "리뷰 삭제", notes = "리뷰 삭제")
    public ResponseEntity<?> deleteReview(@PathVariable int review_code) {
        reviewService.deleteReview(review_code);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    

    // 5. 리뷰 수정
    @PutMapping("/review/{review_code}")
    @ApiOperation(value = "리뷰 수정", notes = "리뷰 수정")
    public ResponseEntity<?> updateReview(@PathVariable int review_code, Review review){
        //없을 때 처리 해야함. 삭제도 마찬가지
        reviewService.updateReview(review);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}
