package com.jhgpt.model.dto;

public class BuyList {
	int buylist_code;
	int member_code;
	int video_code;
	
	public int getBuylist_code() {
		return buylist_code;
	}
	public void setBuylist_code(int buylist_code) {
		this.buylist_code = buylist_code;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public int getVideo_code() {
		return video_code;
	}
	public void setVideo_code(int video_code) {
		this.video_code = video_code;
	}
	@Override
	public String toString() {
		return "BuyList [buylist_code=" + buylist_code + ", member_code=" + member_code + ", video_code=" + video_code
				+ "]";
	}
	
	
	

}
