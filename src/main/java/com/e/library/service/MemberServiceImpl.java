package com.e.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.library.dao.MemberDAOImple;
import com.e.library.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAOImple dao;

	@Override
	public void insert(MemberVO memberVO) {
		
		dao.insert(memberVO);
	}

	@Override
	public MemberVO getMember(String memberId) {
		return dao.getMember(memberId);
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
		dao.updateMember(memberVO);
	}

	@Override
	public MemberVO loginCheck(String memberId, String pswd) {
			return dao.loginCheck(memberId, pswd);
	}

	

	

	

}
