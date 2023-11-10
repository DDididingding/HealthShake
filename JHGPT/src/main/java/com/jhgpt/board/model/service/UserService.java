package com.jhgpt.board.model.service;

import java.util.List;

import com.jhgpt.board.model.dto.User;

public interface UserService {

	//유저 목록 받아옥옥
	List<User> getUserList();

	//회원가입
	int signup(User user);
	
	//로그인
	User login(User user);
	
	//로그아웃
	User logout(int user_id);
	
	//유저 삭제
	Void deleteUser(int user_id);
	
}
