package com.e.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e.library.mapper.RentMapper;
import com.e.library.model.DTO;
import com.e.library.model.RentVO;

@Repository
public class RentDAOImpl implements RentDAO {
	
	@Autowired
	RentMapper mapper;

	@Override
	public void rent(DTO dto) {
		System.out.println(dto);
		mapper.rent(dto);

	}
	
	@Override
	public void backRent(String rentId) {
		mapper.backRent(rentId);
	}
	
	@Override
	public void updateBookStatus(DTO dto) {
		mapper.updateBookStatus(dto);
	}
	
	@Override
	public int getRentCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<RentVO> getRents(String memberId) {
		return mapper.getRents(memberId);
	}
	@Override
	public List<RentVO> getAllRents() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RentVO getRent(String bookId) {
		return mapper.getRent(bookId);
	}

	

}
