package com.e.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e.library.mapper.MemberMapper;
import com.e.library.model.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO {

	@Autowired
	private MemberMapper mapper;

	@Override
	public void insert(MemberVO memberVO) {
		
		mapper.insert(memberVO);
	}

	@Override
	public MemberVO getMember(String memberId) {
		return mapper.getMember(memberId);
	}

	@Override
	public List<MemberVO> getMembers() {
		return null;
	}

	@Override
	public int getMemberCount() {
		return 0;
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		mapper.updateMember(memberVO);
	}

	@Override
	public MemberVO loginCheck(String memberId, String pswd) {
		return mapper.loginCheck(memberId, pswd);
	}

	

	
	
	
	
	

}
