package com.jhgpt.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhgpt.board.model.dao.BoardDao;
import com.jhgpt.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao;
	@Override
	public List<Board> getList() {
		// TODO Auto-generated method stub
		return boardDao.selectAll();
	}

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		boardDao.insertBoard(board);
	}

	@Override
	public Board getBoard(int id) {
		// 조회수를 증가시키고
		boardDao.updateViewCnt(id);
		//하나 골라서 가져온다
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
		
	}

	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(id);
		
	}
	
}
