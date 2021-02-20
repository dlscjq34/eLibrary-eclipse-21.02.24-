package com.e.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.library.dao.FavorBookDAOImpl;
import com.e.library.model.DTO;

@Service
public class FavorBookServiceImpl implements FavorBookService {
	
	@Autowired
	FavorBookDAOImpl dao;

	@Override
	public void favorBook(DTO dto) {
		dao.favorBook(dto);
	}

}
