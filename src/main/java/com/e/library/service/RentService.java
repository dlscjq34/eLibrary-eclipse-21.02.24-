package com.e.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.e.library.model.DTO;
import com.e.library.model.RentVO;

@Service
public interface RentService {
	
	public void rent(DTO dto);//대출 신청
	
	public void backRent(RentVO rentVO);//대출 반납
	
	public RentVO getRent(String bookId);//대출 찾기
	
	public List<DTO> getRents(String memberId);//멤버의 대출목록 찾기
	
	public List<RentVO> getAllRents();//모든 대출
	
	public int getRentCount();//모든 대출 수
	
	

}
