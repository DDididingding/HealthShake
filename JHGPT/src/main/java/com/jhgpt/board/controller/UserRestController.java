package com.jhgpt.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhgpt.board.model.service.UserService;
import com.jhgpt.board.model.dto.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags="이용자 컨트롤러")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	//전체유저가져와
	@GetMapping("/user")
	public List<User> getUserList() {
	    return userService.getUserList();
	}
	
	// GetMapping
	// search(READ)
	@GetMapping("/user/{user_id}")
	@ApiOperation(value = "{user_id}에 해당하는 유저 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> select(@PathVariable int user_id) {
	    
	    User user = userService.selectOne(user_id);
	    if(user==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//회원가입을 해보자 form 태그 형식으로 넘어왔다.
	@PostMapping("signup")
	public ResponseEntity<Integer> signup(User user) {
	    int result = userService.signup(user);
	    
	    //result 가 0이면 등록 x
	    //result 가 1이면 등록 o
	    return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("login")
	public ResponseEntity<?> login(User user, HttpSession session) {
	    User tmp = userService.login(user);
	    //로그인 실패 (잘못했어)
	    if(tmp == null)
	        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	    
	    session.setAttribute("loginUser", tmp.getName());
	    return new ResponseEntity<String>(tmp.getName(), HttpStatus.OK);
	}
	
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
	//        session.removeAttribute("loginUser");
	        session.invalidate();
	
	        return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// DeleteMapping
	// delete(DELETE)
	@DeleteMapping("/user/{user_id}")
	@ApiOperation(value = "movie 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<Void> deleteUser(@PathVariable int user_id) {
	    userService.deleteUser(user_id);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}

