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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhgpt.model.dto.Member;
import com.jhgpt.model.dto.User;
import com.jhgpt.model.dto.Trainer;
import com.jhgpt.model.service.MemberService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags="이용자 컨트롤러")
public class MemberRestController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member")
	@ApiOperation(value = "멤버 전체 조회", notes = "멤버 전체 조회")
	public ResponseEntity<?> getMemberList() {
		
		List<Member> list = memberService.getAllMember();

		if(list.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}

	//전체유저가져오기
	@GetMapping("/user")
	@ApiOperation(value = "유저 전체 조회", notes = "유저 전체 조회")
	public ResponseEntity<?> getUserList() {
		
		List<User> list = memberService.getAllUser();

		if(list.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	//전체트레이너가져오기
	@GetMapping("/trainer")
	@ApiOperation(value = "트레이너 전체 조회", notes = "트레이너 전체 조회")
	public ResponseEntity<?> getTrainerList() {
		
		List<Trainer> list = memberService.getAllTrainer();

		//리스트가 비어있을 때 204 No Content 반환
		if(list.isEmpty())
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Trainer>>(list, HttpStatus.OK);
	}

	
	// search(READ)
	@GetMapping("/user/{member_code}")
	@ApiOperation(value = "{member_code}에 해당하는 유저 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectUser(@PathVariable int member_code) {
	    
	    User user = memberService.selectOneUser(member_code);
	    if(user==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/trainer/{member_code}")
	@ApiOperation(value = "{member_code}에 해당하는 트레이너 정보를 반환한다.", response = Trainer.class)
	public ResponseEntity<?> selectTrainer(@PathVariable int member_code) {
	    
	    Trainer trainer = memberService.selectOneTrainer(member_code);
	    if(trainer==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
	}
	
	@GetMapping("/member/{member_id}")
	@ApiOperation(value = "{member_id}에 해당하는 멤버 정보를 반환한다.", response = Member.class)
	public ResponseEntity<?> selectMember(@PathVariable String member_id) {
	    
	    Member member = memberService.selectOneMemberById(member_id);
	    if(member==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	@GetMapping("/Mypage/{member_code}")
	@ApiOperation(value = "{member_code}에 해당하는 멤버의 마이페이지", response = Member.class)
	public ResponseEntity<?> selectMypage(@PathVariable int member_code) {
	    
	    Member member = memberService.selectOneMember(member_code);
	    if(member==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
		if(member.getMember_status() == 1){
			User user = memberService.selectOneUser(member_code);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		else if(member.getMember_status() == 2){
			Trainer trainer = memberService.selectOneTrainer(member_code);
			return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
		}

	    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/Mypage/{member_code}/user")
	@ApiOperation(value = "{member_code}에 해당하는 유저의 마이페이지", response = User.class)
	public ResponseEntity<?> selectUserMypage(@PathVariable int member_code) {
	    
	    User user = memberService.selectOneUser(member_code);
	    if(user==null || user.getMember_status() != 1) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/Mypage/{member_code}/trainer")
	@ApiOperation(value = "{member_code}에 해당하는 트레이너의 마이페이지", response = Trainer.class)
	public ResponseEntity<?> selectTrainerMypage(@PathVariable int member_code) {
	    
	    Trainer trainer = memberService.selectOneTrainer(member_code);
	    if(trainer==null || trainer.getMember_status() != 2) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<Trainer>(trainer, HttpStatus.OK);
	}
	
	@GetMapping("/userbuylist/{user_member_code}")
	@ApiOperation(value = "{user_member_code}에 해당하는 멤버의 구매내역", response = Member.class)
	public ResponseEntity<?> selectUserBuyList(@PathVariable int user_member_code) {
	    
		List<Trainer> buyList = memberService.selectPurchasedList(user_member_code);
	    if(buyList==null) {
	        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<List<Trainer>>(buyList, HttpStatus.OK);
	    
	}

	@PostMapping("signup/user")
	@ApiOperation(value = "유저 객체를 등록한다.", response = Integer.class)
	public ResponseEntity<Integer> userSignup(@RequestBody User user) {
		System.out.println(user);
	    Member member = memberService.selectOneMemberById(user.getMember_id());
		if(member != null) {
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}

		int result = memberService.signup(user);
	    
	    //result 가 0이면 등록 x
	    //result 가 1이면 등록 o
	    return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	@PostMapping("signup/trainer")
	public ResponseEntity<Integer> trainerSignup(@RequestBody Trainer trainer) {
		//result 가 0이면 등록 x
		//result 가 1이면 등록 o
		//result 가 2이면 아이디 중복

	    Member member = memberService.selectOneMemberById(trainer.getMember_id());
		if(member != null) {
			return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}

		int result = memberService.signup(trainer);
	    
	    return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody Member member, HttpSession session) {
	    Member tmp = memberService.login(member);
	    //로그인 실패 (잘못했어)
	    if(tmp == null){
	        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	    
		//로그인 성공
		//세션에 로그인한 유저의 이름을 저장한다.	
	    session.setAttribute("loginMember", tmp);
		//로그인한 유저의 이름을 반환한다.
	    return new ResponseEntity<Member>(tmp, HttpStatus.OK);
	}
	
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
	//        session.removeAttribute("loginUser");
	        session.invalidate();
	        
	        return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("buytrainer/{user_code}/{trainer_code}")
	
	
	// UpdateMapping
	// put(PUT)
	@PutMapping("/member/{member_code}")
	@ApiOperation(value = "멤버 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<Void> updateMember(@PathVariable int member_code, @RequestBody Member member) {
		Member tmp = memberService.selectOneMember(member_code);
		if (tmp == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		memberService.updateMember(member);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/user/{member_code}/update")
	@ApiOperation(value = "유저 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<Void> updateUser(@PathVariable int member_code, @RequestBody User user) {
		System.out.println(user);
		User tmp = memberService.selectOneUser(member_code);
		if (tmp == null || tmp.getMember_status() != 1) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		memberService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/trainer/{member_code}/update")
	@ApiOperation(value = "트레이너 객체를 수정한다.", response = Integer.class)
	public ResponseEntity<Void> updateTrainer(@PathVariable int member_code, @RequestBody Trainer trainer) {
		Trainer tmp = memberService.selectOneTrainer(member_code);
		if (tmp == null || tmp.getMember_status() != 2) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		memberService.updateTrainer(trainer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	// DeleteMapping
	// delete(DELETE)
	@DeleteMapping("/member/{member_code}/delete")
	@ApiOperation(value = "멤버 객체를 삭제한다.", response = Integer.class)
	public ResponseEntity<Void> deleteUser(@PathVariable int member_code) {
	    Member member = memberService.selectOneMember(member_code);
		if(member == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		if(member.getMember_status() == 0) {
			System.out.println("삭제 불가한 회원입니다.");
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}

		memberService.deleteMember(member_code);
	    return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/prefer/{member_code}")
	@ApiOperation(value = "{member_code}를 가진 사람과 잘 맞는 트레이너 혹은 유저 top 5 가져오기", response = Integer.class)
	public ResponseEntity<?> selectPrefer(@PathVariable int member_code) {
		Member member = memberService.selectOneMember(member_code);
		if(member == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		if(member.getMember_status() == 1) {
			User user = memberService.selectOneUser(member_code);
			List<Trainer> list = memberService.GetTrainerListByPrefer(user);
			return new ResponseEntity<List<Trainer>>(list, HttpStatus.OK);
		}
		if(member.getMember_status() == 2) {
			Trainer trainer = memberService.selectOneTrainer(member_code);
			List<User> list = memberService.GetUserListByPrefer(trainer);
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}

