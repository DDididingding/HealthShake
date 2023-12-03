package com.jhgpt.model.dto;

public class Board {
	private int board_code;
	private int member_code;
	private String board_title;
	private String board_content;
	private int board_uploader;
	private int board_viewcnt;
	private String board_uploadtime;
	private String board_modify_status;

	public int getBoard_code() {
		return board_code;
	}

	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public int getBoard_uploader() {
		return board_uploader;
	}

	public void setBoard_uploader(int board_uploader) {
		this.board_uploader = board_uploader;
	}

	public int getBoard_viewcnt() {
		return board_viewcnt;
	}

	public void setBoard_viewcnt(int board_viewcnt) {
		this.board_viewcnt = board_viewcnt;
	}

	public String getBoard_uploadtime() {
		return board_uploadtime;
	}

	public void setBoard_uploadtime(String board_uploadtime) {
		this.board_uploadtime = board_uploadtime;
	}

	public String getBoard_modify_status() {
		return board_modify_status;
	}

	public void setBoard_modify_status(String board_modify_status) {
		this.board_modify_status = board_modify_status;
	}

	@Override
	public String toString() {
		return "Board [board_code=" + board_code + ", member_code=" + member_code + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_uploader=" + board_uploader + ", board_viewcnt="
				+ board_viewcnt + ", board_uploadtime=" + board_uploadtime + ", board_modify_status="
				+ board_modify_status + "]";
	}
}
