package com.jhgpt.model.dto;

public class Trainer extends Member{
	
	private int member_code;
    private String provide_part;
    private String provide_style;
    private String provide_goal;
    private String video_list;
    private String trainer_readme;
    private int trainer_price;
    private String trainer_review;
    private double trainer_rating;
    
    public Trainer() {
		// TODO Auto-generated constructor stub
	}
    
    
	public Trainer(int member_code, String provide_part, String provide_style, String provide_goal, String video_list,
			String trainer_readme, int trainer_price, String trainer_review, double trainer_rating) {
		super();
		this.member_code = member_code;
		this.provide_part = provide_part;
		this.provide_style = provide_style;
		this.provide_goal = provide_goal;
		this.video_list = video_list;
		this.trainer_readme = trainer_readme;
		this.trainer_price = trainer_price;
		this.trainer_review = trainer_review;
		this.trainer_rating = trainer_rating;
	}


	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public String getProvide_part() {
		return provide_part;
	}
	public void setProvide_part(String provide_part) {
		this.provide_part = provide_part;
	}
	public String getProvide_style() {
		return provide_style;
	}
	public void setProvide_style(String provide_style) {
		this.provide_style = provide_style;
	}
	public String getProvide_goal() {
		return provide_goal;
	}
	public void setProvide_goal(String provide_goal) {
		this.provide_goal = provide_goal;
	}
	public String getVideo_list() {
		return video_list;
	}
	public void setVideo_list(String video_list) {
		this.video_list = video_list;
	}
	public String getTrainer_readme() {
		return trainer_readme;
	}
	public void setTrainer_readme(String trainer_readme) {
		this.trainer_readme = trainer_readme;
	}
	public int getTrainer_price() {
		return trainer_price;
	}
	public void setTrainer_price(int trainer_price) {
		this.trainer_price = trainer_price;
	}
	public String getTrainer_review() {
		return trainer_review;
	}
	public void setTrainer_review(String trainer_review) {
		this.trainer_review = trainer_review;
	}
	public double getTrainer_rating() {
		return trainer_rating;
	}
	public void setTrainer_rating(double trainer_rating) {
		this.trainer_rating = trainer_rating;
	}
    
    

}
