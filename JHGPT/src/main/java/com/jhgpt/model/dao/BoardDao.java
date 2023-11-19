package com.jhgpt.model.dao;

import java.util.List;
import com.jhgpt.model.dto.Board;

public interface BoardDao {
	List<Board> selectAllBoards();

	Board selectOneBoard(int board_code);

	void insertBoard(Board board);

	void deleteBoard(int board_code);

	void updateBoard(Board board);

	List<Board> selectUserBoards(int member_code); // 유저 코드별로 게시글 가져오기
	
	List<Board> selectMeberBoards(int member_code); // 사용자 코드별로 게시글 가져오기

	List<Board> selectTrainerBoards(int member_code); //트레이너 코드로 게시글 가져오기

	List<Board> selectWriterBoards(int board_uploader); // 업로더에 따른 게시글 가져오기

	List<Board> selectAllBoardsBySearch(String searchType, String searchValue); // 검색 조건에 따른 게시글 가져오기
	
}
