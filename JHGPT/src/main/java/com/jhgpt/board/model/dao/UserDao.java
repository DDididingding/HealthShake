package com.jhgpt.board.model.dao;

import java.util.List;

import com.jhgpt.board.model.dto.User;

public interface UserDao {
	
	//전체유저 받아오기
	List<User> selectAll();

	//유저 등록
	int insertUser(User user);
	
	//유저 고르기
	User selectOne(String id);
	
	//유저 삭제
	Void deleteUser(int user_id);
}
