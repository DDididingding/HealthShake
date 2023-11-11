package com.jhgpt.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.board.model.dto.Board;

@Service
public interface BoardService {
	// 게시글 전체 조회
	List<Board> getList();

	// 게시글 등록
	void writeBoard(Board board);

	// 게시글 상세 조회
	Board getBoard(int id);

	// 게시글 수정
	void modifyBoard(Board board);

	// 게시글 삭제
	void removeBoard(int id);
}
