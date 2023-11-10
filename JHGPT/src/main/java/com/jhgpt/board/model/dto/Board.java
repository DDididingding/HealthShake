package com.jhgpt.board.model.dto;

public class Board {
	private String video_id;
	private String title;
	private String content;
	private String writer_id;
	private int view_cnt;
	private String post_time;
	private String modified_time;
	public String getVideo_id() {
		return video_id;
	}
	public void setVideo_id(String video_id) {
		this.video_id = video_id;
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
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getPost_time() {
		return post_time;
	}
	public void setPost_time(String post_time) {
		this.post_time = post_time;
	}
	public String getModified_time() {
		return modified_time;
	}
	public void setModified_time(String modified_time) {
		this.modified_time = modified_time;
	}
	@Override
	public String toString() {
		return "Board [video_id=" + video_id + ", title=" + title + ", content=" + content + ", writer_id=" + writer_id
				+ ", view_cnt=" + view_cnt + ", post_time=" + post_time + ", modified_time=" + modified_time + "]";
	}
	
	

}
