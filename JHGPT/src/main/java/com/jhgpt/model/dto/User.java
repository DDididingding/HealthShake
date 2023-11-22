package com.jhgpt.model.dto;

public class User extends Member{

	private int member_code;
	private String prefer_part;
	private String prefer_gender;
	private String prefer_style;
	private String prefer_goal;
	private String user_readme;

	// getters and setters
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(int member_code, String prefer_part, String prefer_gender, String prefer_style, String prefer_goal,
			String user_readme, String buy_list) {
		super();
		this.member_code = member_code;
		this.prefer_part = prefer_part;
		this.prefer_gender = prefer_gender;
		this.prefer_style = prefer_style;
		this.prefer_goal = prefer_goal;
		this.user_readme = user_readme;
	}



	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public String getPrefer_part() {
		return prefer_part;
	}

	public void setPrefer_part(String prefer_part) {
		this.prefer_part = prefer_part;
	}

	public String getPrefer_gender() {
		return prefer_gender;
	}

	public void setPrefer_gender(String prefer_gender) {
		this.prefer_gender = prefer_gender;
	}

	public String getPrefer_style() {
		return prefer_style;
	}

	public void setPrefer_style(String prefer_style) {
		this.prefer_style = prefer_style;
	}

	public String getPrefer_goal() {
		return prefer_goal;
	}

	public void setPrefer_goal(String prefer_goal) {
		this.prefer_goal = prefer_goal;
	}

	public String getUser_readme() {
		return user_readme;
	}

	public void setUser_readme(String user_readme) {
		this.user_readme = user_readme;
	}


	@Override
	public String toString() {
		return "User [member_code=" + member_code + ", prefer_part=" + prefer_part + ", prefer_gender=" + prefer_gender
				+ ", prefer_style=" + prefer_style + ", prefer_goal=" + prefer_goal + ", user_readme=" + user_readme
				+ ", member_id=" + member_id + ", member_password=" + member_password + ", member_name=" + member_name
				+ ", member_nickname=" + member_nickname + ", member_age=" + member_age + ", member_gender="
				+ member_gender + ", member_profile_pic=" + member_profile_pic + ", member_status=" + member_status
				+ "]";
	}



	
	

}
