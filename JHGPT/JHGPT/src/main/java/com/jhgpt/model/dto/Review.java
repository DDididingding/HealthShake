package com.jhgpt.model.dto;

public class Review {
    private int review_code;
    private int member_code; // 트레이너
    private int review_writer; // 작성자
    private int review_rating;
    private String review_content;
    private String review_uploadtime;
    private int review_like;
    private int review_dislike;

    public Review() {
		// TODO Auto-generated constructor stub
	}

	public int getReview_code() {
		return review_code;
	}

	public void setReview_code(int review_code) {
		this.review_code = review_code;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public int getReview_writer() {
		return review_writer;
	}

	public void setReview_writer(int review_writer) {
		this.review_writer = review_writer;
	}

	public int getReview_rating() {
		return review_rating;
	}

	public void setReview_rating(int review_rating) {
		this.review_rating = review_rating;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_uploadtime() {
		return review_uploadtime;
	}

	public void setReview_uploadtime(String review_uploadtime) {
		this.review_uploadtime = review_uploadtime;
	}

	public int getReview_like() {
		return review_like;
	}

	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}

	public int getReview_dislike() {
		return review_dislike;
	}

	public void setReview_dislike(int review_dislike) {
		this.review_dislike = review_dislike;
	}


    
    
    
    

}

