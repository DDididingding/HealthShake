package com.jhgpt.model.dto;

public class Member {
	int member_code;
	String member_id;
	String member_password;
	String member_name;
	String member_nickname;
	Integer member_age;
	String member_gender;
	String member_profile_pic;
	Integer member_status;

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public Integer getMember_age() {
		return member_age;
	}

	public void setMember_age(Integer member_age) {
		this.member_age = member_age;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public Integer getMember_status() {
		return member_status;
	}

	public void setMember_status(Integer member_status) {
		this.member_status = member_status;
	}

	public String getMember_profile_pic() {
		return member_profile_pic;
	}

	public void setMember_profile_pic(String member_profile_pic) {
		this.member_profile_pic = member_profile_pic;
	}

	@Override
	public String toString() {
		return "Member [member_code=" + member_code + ", member_id=" + member_id + ", member_password="
				+ member_password + ", member_name=" + member_name + ", member_nickname=" + member_nickname
				+ ", member_age=" + member_age + ", member_gender=" + member_gender + ", member_profile_pic="
				+ member_profile_pic + ", member_status=" + member_status + "]";
	}
	
	
}
