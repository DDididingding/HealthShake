package com.jhgpt.model.dao;

import java.util.List;

import com.jhgpt.model.dto.Member;
import com.jhgpt.model.dto.Trainer;
import com.jhgpt.model.dto.User;

public interface MemberDao {

	List<Member> selectAllMembers();

	Member selectOneMember(int member_code);

	Member selectOneMemberById(String member_id);

	List<int> selectPurchasedVideoList(int member_code);
	
	void insertMemberU(User user);

	void insertMemberT(Trainer trainer);

	void deleteMember(int member_code);

	void updateMember(Member member);

	
}
