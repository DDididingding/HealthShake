package com.jhgpt.model.dto;

public class BuyList {
	int buylist_code;
	int user_member_code;
	int trainer_member_code;
	String buy_date;
	public int getBuylist_code() {
		return buylist_code;
	}
	public void setBuylist_code(int buylist_code) {
		this.buylist_code = buylist_code;
	}
	public int getUser_member_code() {
		return user_member_code;
	}
	public void setUser_member_code(int user_member_code) {
		this.user_member_code = user_member_code;
	}
	public int getTrainer_member_code() {
		return trainer_member_code;
	}
	public void setTrainer_member_code(int trainer_member_code) {
		this.trainer_member_code = trainer_member_code;
	}
	public String getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}
	@Override
	public String toString() {
		return "BuyList [buylist_code=" + buylist_code + ", user_member_code=" + user_member_code
				+ ", trainer_member_code=" + trainer_member_code + ", buy_date=" + buy_date + "]";
	}
	
	
	
	

}
