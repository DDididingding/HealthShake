package com.jhgpt.board.model.dto;

public class Review {
	private int review_id;
	private int video_id;
	private int member_id;
	private String title;
	private String content;
	private int rating;
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", video_id=" + video_id + ", member_id=" + member_id + ", title="
				+ title + ", content=" + content + ", rating=" + rating + "]";
	}
	
	

}
