package com.jhgpt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhgpt.model.dao.BoardDao;
import com.jhgpt.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	@Override
	public List<Board> getList() {
		
		return boardDao.selectAllBoards();
	}

	@Override
	public void writeBoard(Board board) {
		
		boardDao.insertBoard(board);
	}

	@Override
	public Board getBoard(int board_code) {
		//하나 골라서 가져온다
		return boardDao.selectOneBoard(board_code);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
		
	}

	@Override
	public void removeBoard(int board_code) {
		
		boardDao.deleteBoard(board_code);
		
	}

	@Override
	public List<Board> getListByCode(int member_code) {
		
		return boardDao.selectMeberBoards(member_code);
	}

	@Override
	public List<Board> getListByTrainer(int member_code) {
		
		return boardDao.selectTrainerBoards(member_code);
	}

	@Override
	public List<Board> getStatusList(int member_status) {
		
		return boardDao.selectAllBoardsByStatus(member_status);
	}
	
}
