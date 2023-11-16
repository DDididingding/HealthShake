package com.jhgpt.model.dao;

import java.util.List;

import com.jhgpt.model.dto.Member;

public interface MemberDao {

	List<Member> selectAllMembers();

	Member selectOneMember(int member_code);

	void insertMember(Member member);

	void deleteMember(int member_code);

	void updateMember(Member member);
}
