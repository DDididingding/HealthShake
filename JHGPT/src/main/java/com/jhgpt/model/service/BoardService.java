package com.jhgpt.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.model.dto.Board;

@Service
public interface BoardService {
	// 게시글 전체 조회
	List<Board> getList();

	// 게시글 등록
	void writeBoard(Board board);

	// 게시글 상세 조회
	Board getBoard(int member_code);

	// 게시글 수정
	void modifyBoard(Board board);

	// 게시글 삭제
	void removeBoard(int member_code);
	
	//멤버 코드로 게시글 가져오기
	List<Board> getListByCode(int member_code);

	//트레이너 코드로 게시글 가져오기
	List<Board> getListByTrainer(int member_code);
	
	//멤버 유형별로 게시글 가져오기
	List<Board> getStatusList(int member_status);

	//검색 조건에 따른 글 목록 가져오기
	List<Board> getListBySearch(String searchType, String searchValue);


}
