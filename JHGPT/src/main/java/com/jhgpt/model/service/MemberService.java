package com.jhgpt.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhgpt.model.dto.Member;
import com.jhgpt.model.dto.User;
import com.jhgpt.model.dto.Trainer;

@Service
public interface MemberService {

	//멤버 목록 받아오기
	public List<Member> getAllMember();
	
	//유저 목록 받아오기
	public List<User> getAllUser();

	//트레이너 목록 받아오기
	public List<Trainer> getAllTrainer();
	
	//멤버 고르기
	public Member selectOneMember(int Member_code);

	//아이디로 멤버 고르기
	public Member selectOneMemberById(String Member_id);
	
	//유저 고르기
	public User selectOneUser(int Member_code);
	
	//트레이너 고르기
	public Trainer selectOneTrainer(int Member_code);
	
	//유저가 구매한 트레이너 목록 가져오기
	public List<Trainer> selectPurchasedList(int user_member_code);
	
	//유저 회원가입
	public int signup(User user);
	
	//트레이너 회원가입 //오버로딩 구현
	public int signup(Trainer trainer);
	
	//로그인
	public Member login(Member member);
	
	//로그아웃
	public Member logout(int member_code);
	
	//유저 삭제
	public void deleteMember(int member_code);

	//멤버 정보 수정
	public void updateMember(Member member);

	//유저 정보 수정
	public void updateUser(User user);
	
	//트레이너 정보 수정
	public void updateTrainer(Trainer trainer);
	
	//유저의 관심사로 트레이너 리스트 가져오기
	public List<Trainer> GetTrainerListByPrefer(User user);
	
	//트레이너의 관심사로 유저리스트 가져오기
	public List<User> GetUserListByPrefer(Trainer trainer);
	
}
