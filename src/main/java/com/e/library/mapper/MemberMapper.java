package com.e.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.e.library.model.MemberVO;

public interface MemberMapper {
	
	
	public void insert(MemberVO memberVO);//회원 가입
	
	public MemberVO loginCheck(@Param("memberId") String memberId, @Param("pswd")String pswd);//로그인 체크
	
	public MemberVO getMember(String memberId);//회원 찾기
	
	public List<MemberVO> getMembers();//모든 회원
	
	public int getMemberCount();//모든 회원 수
	
	public void updateMember(MemberVO memberVO);//회원정보 수정
	
	
	
	
	
}
