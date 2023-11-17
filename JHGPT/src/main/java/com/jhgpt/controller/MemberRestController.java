package com.jhgpt.controller;

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

import com.jhgpt.model.dto.Member;
import com.jhgpt.model.dto.User;
import com.jhgpt.model.dto.Trainer;
import com.jhgpt.model.service.MemberService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
@Api(tags="이용자 컨트롤러")
public class MemberRestController {

	@Autowired
	private MemberService memberService;
	
	//전체멤버가져오기
	@GetMapping("/member")
	public ResponseEntity<?> getMemberList() {
		
		List<Member> list = memberService.getAllMember();
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}

	//전체유저가져오기
	@GetMapping("/user")
	public ResponseEntity<?> getUserList() {
		
		List<User> list = memberService.getAllUser();
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	//전체트레이너가져오기
	@GetMapping("/trainer")
	public ResponseEntity<?> getTrainerList() {
		
		List<Trainer> list = memberService.getAllTrainer();
		
		return new ResponseEntity<List<Trainer>>(list, HttpStatus.OK);
	}

	
	// search(READ)
	@GetMapping("/user/{member_id}")
	@ApiOperation(value = "{member_id}에 해당하는 유저 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectUser(@PathVariable int member_id) {
	    
	    User user = memberService.selectOneUser(member_id);
	    if(user==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/trainer/{member_id}")
	@ApiOperation(value = "{member_id}에 해당하는 트레이너 정보를 반환한다.", response = Trainer.class)
	public ResponseEntity<?> selectTrainer(@PathVariable int member_id) {
	    
	    Trainer trainer = memberService.selectOneTrainer(member_id);
	    if(trainer==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
	}
	
	//회원가입을 해보자 form 태그 형식으로 넘어왔다.
	@PostMapping("signup/user")
	public ResponseEntity<Integer> userSignup(@RequestBody User user) {
	    int result = memberService.signup(user);
	    
	    //result 가 0이면 등록 x
	    //result 가 1이면 등록 o
	    return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	@PostMapping("signup/trainer")
	public ResponseEntity<Integer> trainerSignup(@RequestBody Trainer trainer) {
	    int result = memberService.signup(trainer);
	    
	    //result 가 0이면 등록 x
	    //result 가 1이면 등록 o
	    return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody Member member, HttpSession session) {
	    Member tmp = memberService.login(member);
	    //로그인 실패 (잘못했어)
	    if(tmp == null)
	        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	    
		//로그인 성공
		//세션에 로그인한 유저의 이름을 저장한다.	
	    session.setAttribute("loginMember", tmp.getMember_name());
		//로그인한 유저의 이름을 반환한다.
	    return new ResponseEntity<String>(tmp.getMember_name(), HttpStatus.OK);
	}
	
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
	//        session.removeAttribute("loginUser");
	        session.invalidate();
	
	        return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// UpdateMapping
	// put(PUT)
	@PostMapping("/member/{member_code}")
	@ApiOperation(value = "멤버 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<Void> updateMember(@PathVariable int member_code,@RequestBody Member member) {
	    Member tmp = memberService.selectOneMember(member_code);
		if(tmp == null){
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }

	    memberService.updateMember(member);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/user/{member_code}")
	@ApiOperation(value = "유저 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<Void> updateUser(@PathVariable int member_code,@RequestBody User user) {
	    User tmp = memberService.selectOneUser(member_code);
		if(tmp == null){
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }

	    memberService.updateUser(user);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/trainer/{member_code}")
	@ApiOperation(value = "트레이너 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<Void> updateTrainer(@PathVariable int member_code,@RequestBody Trainer trainer) {
	    Trainer tmp = memberService.selectOneTrainer(member_code);
		if(tmp == null){
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }

	    memberService.updateTrainer(trainer);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}


	// DeleteMapping
	// delete(DELETE)
	@DeleteMapping("/member/{member_code}")
	@ApiOperation(value = "멤버 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<Void> deleteUser(@PathVariable int member_code) {
	    memberService.deleteMember(member_code);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}

