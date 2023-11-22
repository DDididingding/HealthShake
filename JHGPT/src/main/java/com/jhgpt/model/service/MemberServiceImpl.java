package com.jhgpt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhgpt.model.dao.MemberDao;
import com.jhgpt.model.dao.TrainerDao;
import com.jhgpt.model.dao.UserDao;
import com.jhgpt.model.dto.Member;
import com.jhgpt.model.dto.Trainer;
import com.jhgpt.model.dto.User;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
    private MemberDao memberDao;
	
	@Autowired
    private UserDao userDao;
	
	@Autowired
    private TrainerDao trainerDao;

    // 다른 메서드들과 마찬가지로 각각의 DAO에서 데이터를 가져오는 로직을 작성해주세요.

    @Override
    public List<Member> getAllMember() {
        return memberDao.selectAllMembers();
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectAllUsers();
    }

    @Override
    public List<Trainer> getAllTrainer() {
        return trainerDao.selectAllTrainers();
    }

    @Override
    public Member selectOneMember(int member_code) {
        return memberDao.selectOneMember(member_code);
    }

	@Override
	public Member selectOneMemberById(String member_id) {
		return memberDao.selectOneMemberById(member_id);
	}

    @Override
    public User selectOneUser(int member_code) {
		Member tmp = memberDao.selectOneMember(member_code);
		if(tmp.getMember_status() == 1) {
			return userDao.selectOneUser(member_code);
		}
		return null;
			
    }

    @Override
    public Trainer selectOneTrainer(int member_code) {
		Member tmp = memberDao.selectOneMember(member_code);
		if(tmp.getMember_status() == 2) {
    		return trainerDao.selectOneTrainer(member_code);
		}
		return null;
    }

	@Override
	public int signup(User user) {
		memberDao.insertMemberU(user);
		userDao.insertUser(user);
		return 1; //성공
	}

	@Override
	public int signup(Trainer trainer) {
		memberDao.insertMemberT(trainer);
		trainerDao.insertTrainer(trainer);
		return 1;
	}

	@Override
	public Member login(Member member) {
		Member tmp = memberDao.selectOneMemberById(member.getMember_id());
		 if(tmp != null && tmp.getMember_password().equals(member.getMember_password()))
			return tmp;
		 return null;
	}

	@Override
	public Member logout(int member_code) {
		
		return null;
	}

	@Override
	public void deleteMember(int member_code) {
		
		Member tmp = memberDao.selectOneMember(member_code);
		if(tmp.getMember_status() == 1) {
			userDao.deleteUser(member_code);
			memberDao.deleteMember(member_code);
		}else if(tmp.getMember_status() == 2){
			trainerDao.deleteTrainer(member_code);
			memberDao.deleteMember(member_code);
		}else {
			
		}
	}

	@Override
	public void updateMember(Member member) {
		memberDao.updateMember(member);
	}

	@Override
	public void updateUser(User user) {
		memberDao.updateMember(user);
		userDao.updateUser(user);
	}

	@Override
	public void updateTrainer(Trainer trainer) {
		trainerDao.updateTrainer(trainer);
	}

	@Override
	public List<Trainer> selectPurchasedList(int user_member_code) {
		
		return memberDao.selectPurchasedTrainerList(user_member_code);
	}

	@Override
	public List<Trainer> GetTrainerListByPrefer(User user) {
		// TODO Auto-generated method stub
		return trainerDao.selectTrainersByprefer(user);
	}

	@Override
	public List<User> GetUserListByPrefer(Trainer trainer) {
		// TODO Auto-generated method stub
		return userDao.selectUsersByPrefer(trainer);
	}
	
	
	

    
}
