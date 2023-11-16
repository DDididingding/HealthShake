package com.jhgpt.model.dto;

public class Review {
    private int review_code;
    private int member_code;
    private double review_rating;
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


	public double getReview_rating() {
		return review_rating;
	}


	public void setReview_rating(double review_rating) {
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


	@Override
    public String toString() {
        return "Review [review_code=" + review_code + ", member_code=" + member_code + ", review_rating=" + review_rating
                + ", review_content=" + review_content + ", review_uploadtime=" + review_uploadtime + ", review_like=" + review_like
                + ", review_dislike=" + review_dislike + "]";
    }
}
