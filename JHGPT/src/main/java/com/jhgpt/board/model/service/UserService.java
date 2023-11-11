package com.jhgpt.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.board.model.dto.User;

@Service
public interface UserService {

	//유저 목록 받아옥옥
	public List<User> getUserList();
	//유저 고르기
	public User selectOne(int user_id);
	//회원가입
	public int signup(User user);
	
	//로그인
	public User login(User user);
	
	//로그아웃
	public User logout(int user_id);
	
	//유저 삭제
	public void deleteUser(int user_id);
	
}
