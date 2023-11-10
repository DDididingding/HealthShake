package com.jhgpt.board.model.dto;

public class Video {
	private int video_id;
	private String video_title;
	private String content;
	private String video_url;
	private String part;
	private int view_cnt;
	private int price;
	private String trainer_id; //업로드는 트레이너만
	
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getVideo_title() {
		return video_title;
	}
	public void setVideo_title(String video_title) {
		this.video_title = video_title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(String trainer_id) {
		this.trainer_id = trainer_id;
	}
	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", video_title=" + video_title + ", content=" + content + ", video_url="
				+ video_url + ", part=" + part + ", view_cnt=" + view_cnt + ", price=" + price + ", trainer_id="
				+ trainer_id + "]";
	}
	
	
}
