package com.jhgpt.board.model.dto;

public class Board {
	private int board_id;
	private int video_id;
	private String title;
	private String content;
	private int writer_id;
	private int view_cnt;
	private String post_time;
	private String modified_time;
	
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
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
	public int getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(int writer_id) {
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
		return "Board [board_id=" + board_id + ", video_id=" + video_id + ", title=" + title + ", content=" + content
				+ ", writer_id=" + writer_id + ", view_cnt=" + view_cnt + ", post_time=" + post_time
				+ ", modified_time=" + modified_time + "]";
	}
	
	
	
	

}
