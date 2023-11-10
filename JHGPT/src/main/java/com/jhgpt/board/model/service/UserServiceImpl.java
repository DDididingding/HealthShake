package com.jhgpt.board.model.service;

import java.util.List;

import com.jhgpt.board.model.dao.UserDao;
import com.jhgpt.board.model.dto.User;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public int signup(User user) {
		// TODO Auto-generated method stub
		return userDao.insertUser(user);
	}

	@Override
	public User login(User user) {
		User tmp = userDao.selectOne(user.getId());
		if(tmp != null && tmp.getPassword() == user.getPassword())
			return tmp;
		return null;
	}

	@Override
	public User logout(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void deleteUser(int user_id) {
		userDao.deleteUser(user_id);
		return null;
	}
	
}
