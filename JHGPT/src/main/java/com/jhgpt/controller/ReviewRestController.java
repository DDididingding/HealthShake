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

    @GetMapping("/review")
    @ApiOperation(value = "리뷰 전체 조회", notes = "리뷰 전체 조회")
    public ResponseEntity<?> reviewList() {
        List<Review> list = reviewService.getAllReviews();
        if (list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }

    // 리뷰 상세보기
    @GetMapping("/review/Detail/{review_code}")
    @ApiOperation(value = "리뷰 상세, 하나 가져오기", notes = "리뷰 하나 가져오기")
    public ResponseEntity<?> reviewDetail(@PathVariable int review_code) {
    	Review review = reviewService.selectOneReview(review_code);
    	if (review == null)
    		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    	
    	return new ResponseEntity<Review>(review, HttpStatus.OK);
    }
    
    // 1. 트레이너별 리뷰 목록 조회
    @GetMapping("/trainer/{member_code}/review")
    @ApiOperation(value = "트레이너별 리뷰 목록 조회", notes = "트레이너별 리뷰 목록 조회")
    public ResponseEntity<?> reviewListByTrainer(@PathVariable int member_code) {
        List<Review> list = reviewService.getReviewsByMember(member_code);
        if (list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }
    //멤버가 쓴 리뷰 모아보기
    @GetMapping("/review/{review_writer}")
    @ApiOperation(value = "멤버가 쓴 리뷰 모아보기", notes = "멤버가 쓴 리뷰 모아보기")
    public ResponseEntity<?> reviewListByWriter(@PathVariable int review_writer) {
        List<Review> list = reviewService.getReviewsByWriter(review_writer);
        if (list.isEmpty())
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }




    // 3. 트레이너에 대한 리뷰 등록
    // 리뷰는 냅다 등록하고, 보여줄 때만 트레이너에 대한 리뷰만 보여주기
    @PostMapping("/review")
    @ApiOperation(value = "리뷰 등록", notes = "일단 등록하고 보여줄때 트레이너에 따라 보여주기")
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
    public ResponseEntity<?> updateReview(@PathVariable int review_code, @RequestBody Review review){
        Review temp = reviewService.selectOneReview(review.getReview_code());
        if(temp == null){
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        
        reviewService.updateReview(review);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}
