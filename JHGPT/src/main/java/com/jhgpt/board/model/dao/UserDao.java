package com.jhgpt.board.model.dao;

import java.util.List;

import com.jhgpt.board.model.dto.User;

public interface UserDao {
	
	//전체유저 받아오기
	public List<User> selectAll();

	//유저 등록
	public int insertUser(User user);
	
	//유저 고르기
	public User selectOne(int user_id);
	
	//유저 삭제
	public Void deleteUser(int user_id);
}
