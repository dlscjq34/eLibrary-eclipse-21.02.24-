package com.e.library.dao;

import java.util.List;

import com.e.library.model.DTO;
import com.e.library.model.RentVO;

public interface RentDAO {
	
	public void rent(DTO dto);//대출 신청
	
	public void backRent(String rentId);//대출 반납
	
	public void updateBookStatus(DTO dto);//도서 상태 변경
	
	public RentVO getRent(String bookId);//대출 찾기
	
	public List<RentVO> getRents(String memberId);//멤버의 대출목록 찾기
	
	public List<RentVO> getAllRents();//모든 대출
	
	public int getRentCount();//모든 대출 수

}
