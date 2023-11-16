package com.jhgpt.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhgpt.model.dao.BoardDao;
import com.jhgpt.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao;
	@Override
	public List<Board> getList() {
		// TODO Auto-generated method stub
		return boardDao.selectAllBoards();
	}

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		boardDao.deleteBoard(board_code);
		
	}

	@Override
	public List<Board> getListByCode(int member_code) {
		// TODO Auto-generated method stub
		return boardDao.selectMeberBoards(member_code);
	}

	@Override
	public List<Board> getStatusList(int member_status) {
		// TODO Auto-generated method stub
		return boardDao.selectAllBoardsByStatus(member_status);
	}
	
}
