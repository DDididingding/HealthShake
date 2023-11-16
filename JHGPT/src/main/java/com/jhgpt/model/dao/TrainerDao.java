package com.jhgpt.model.dao;

import java.util.List;
import com.jhgpt.model.dto.Trainer;

public interface TrainerDao extends MemberDao {
	List<Trainer> selectAllTrainers();

	Trainer selectOneTrainer(int member_code);

	void insertTrainer(Trainer trainer);

	void deleteTrainer(int member_code);

	void updateTrainer(Trainer trainer);
}
