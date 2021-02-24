package com.e.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e.library.dao.FavorBookDAOImpl;
import com.e.library.model.BookVO;
import com.e.library.model.DTO;
import com.e.library.model.FavorBookVO;
import com.e.library.model.RentVO;

@Service
public class FavorBookServiceImpl implements FavorBookService {
	
	@Autowired
	FavorBookDAOImpl dao;
	
	
	@Transactional
	@Override
	public boolean favorBook(FavorBookVO favorBookVO) {

		//중복검사 후 등록 여부 결정
		FavorBookVO checkFavorBook = dao.getFavorBook(favorBookVO);
		if(checkFavorBook == null) {
			dao.favorBook(favorBookVO);
			return true;
		}
		else {
			return false; 
		}
	}

	@Override
	public List<BookVO> getFavorBooks(String memberId) {
		return dao.getFavorBooks(memberId);
	}

}
