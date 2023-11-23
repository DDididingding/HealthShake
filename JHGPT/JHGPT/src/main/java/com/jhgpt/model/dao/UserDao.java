package com.jhgpt.model.dao;

import java.util.List;

import com.jhgpt.model.dto.Trainer;
import com.jhgpt.model.dto.User;

public interface UserDao extends MemberDao {
	
	List<User> selectAllUsers();

	User selectOneUser(int member_code);
	
	List<User> selectUsersByPrefer(Trainer trainer);
	
	void insertPerchasedTrainer(User user, Trainer trainer);

	void insertUser(User user);

	void deleteUser(int member_code);

	void updateUser(User user);
	
}
