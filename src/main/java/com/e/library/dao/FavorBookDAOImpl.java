package com.e.library.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e.library.mapper.FavorBookMapper;
import com.e.library.model.BookVO;
import com.e.library.model.DTO;
import com.e.library.model.FavorBookVO;
import com.e.library.model.RentVO;

@Repository
public class FavorBookDAOImpl implements FavorBookDAO {

	@Autowired
	FavorBookMapper mapper;
	
	@Override
	public void favorBook(FavorBookVO favorBookV) {
		mapper.favorBook(favorBookV);
	}

	@Override
	public List<BookVO> getFavorBooks(String memberId) {
		return mapper.getFavorBooks(memberId);
	}

	@Override
	public FavorBookVO getFavorBook(FavorBookVO favorBookVO) {
		return mapper.getFavorBook(favorBookVO);
	}

}
