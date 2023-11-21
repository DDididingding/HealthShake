package com.jhgpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhgpt.model.dto.Board;
import com.jhgpt.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@Api(tags = "게시판 컨트롤러")
//@CrossOrigin("*")
public class BoardRestController {

	@Autowired
	private BoardService boardService;

	// 1. 목록(검색조건 있을 수도 있고 없을 수도 있다.)
	@GetMapping("/board")
	@ApiOperation(value = "게시글 조회", notes = "검색조건도 넣으면 같이 가져온다.")
	public ResponseEntity<?> list() {

		List<Board> list = boardService.getList(); 
		if (list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// @GetMapping("/board/{searchType}/{searchValue}")
	// @ApiOperation(value = "게시글 조회", notes = "검색조건도 넣으면 같이 가져온다.")
	// public ResponseEntity<?> list(@PathVariable(required = false) String searchType,
	// 		@PathVariable(required = false) String searchValue) {
	// 	//검색 조건 있으면 그걸로 조회
	// 	//검색 조건 없으면 전체 조회
	// 	// if(searchType != null && searchValue != null) {
	// 	// 	List<Board> list = boardService.getListBySearch(searchType, searchValue);
	// 	// 	if (list.size() == 0)
	// 	// 		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	// 	// 	return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	// 	// }

	// 	List<Board> list = boardService.getList(); 
	// 	if (list.size() == 0)
	// 		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	// 	return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	// }



	// 2. 상세보기
	@GetMapping("/board/{board_code}")
	public ResponseEntity<?> detail(@PathVariable int board_code) {
		Board board = boardService.getBoard(board_code);
		// 정석이라면 게시글 제목을 클릭해서 상세보기로 들어갈 거니까 여기서 매무리 해도 된다.
		// 꼬옥 주소창을 통해 접근하려고 하는 악의무리가 있기 때문에 만약 없는 값을 보냈을때... 처리를 해주어라.
		if (board == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}

	//멤버 코드 트레이너에 대한 게시글 조회
	@GetMapping("/board/trainer/{member_code}")
	@ApiOperation(value = "트레이너에 대한 게시글 조회", notes = "트레이너에 대한 게시글 조회")
	public ResponseEntity<?> getBoardsByTrainer(@PathVariable int member_code) {
		List<Board> list = boardService.getBoardListByTrainer(member_code);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	//작성자 코드에 대한 게시글 조회
	@GetMapping("/board/writer/{board_uploader}")
	@ApiOperation(value = "작성자에 따른 게시글 조회", notes = "작성자에 따른 게시글 조회")
	public ResponseEntity<?> getBoardsByWriter(@PathVariable int board_uploader) {
		List<Board> list = boardService.getBoardListByUploader(board_uploader);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}


	// 3. 등록
	@PostMapping("/board")
	public ResponseEntity<Board> write(@RequestBody Board board) {
		boardService.writeBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	// 4. 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		boardService.removeBoard(id);
		// 반환 값을 통해서 지워졌는지 / 안지워졌는지 쳌
		// 이상한 값(id) 못하게 막던지
		// 다른사람도 요청 주소를 통해 내글을 지워버릴수 있다. (권한쳌 -> 인터셉터)
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 5. 수정
	@PutMapping("/board") // JSON 형태의 데이터로 넘어왔을 떄 처리하고 싶은데?
	public ResponseEntity<Void> update(@RequestBody Board board) {
		//작성자외의 사람이 접근하면 수정 ㄴㄴ
		boardService.modifyBoard(board);
		// 위와같은 상황 대비

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
