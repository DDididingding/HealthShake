package com.jhgpt.model.dto;

public class Purchase {
	int user_code;
	int trainer_code;

	public Purchase() {
		super();
	}

	public Purchase(int user_code, int trainer_code) {
		super();
		this.user_code = user_code;
		this.trainer_code = trainer_code;
	}
	public int getUser_code() {
		return user_code;
	}
	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}
	public int getTrainer_code() {
		return trainer_code;
	}
	public void setTrainer_code(int trainer_code) {
		this.trainer_code = trainer_code;
	}
	@Override
	public String toString() {
		return "Purchase [user_code=" + user_code + ", trainer_code=" + trainer_code + "]";
	}
	
	
}
