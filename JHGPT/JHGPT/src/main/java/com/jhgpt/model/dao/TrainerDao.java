package com.jhgpt.model.dao;

import java.util.List;
import com.jhgpt.model.dto.Trainer;
import com.jhgpt.model.dto.User;

public interface TrainerDao extends MemberDao {
	List<Trainer> selectAllTrainers();

	Trainer selectOneTrainer(int member_code);
	
	List<Trainer> selectTrainersByprefer(User user);

	void insertTrainer(Trainer trainer);

	void deleteTrainer(int member_code);

	void updateTrainer(Trainer trainer);
}
