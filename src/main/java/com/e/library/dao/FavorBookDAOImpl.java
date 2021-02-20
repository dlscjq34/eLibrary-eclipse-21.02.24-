package com.e.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e.library.mapper.FavorBookMapper;
import com.e.library.model.DTO;

@Repository
public class FavorBookDAOImpl implements FavorBookDAO {

	@Autowired
	FavorBookMapper mapper;
	
	@Override
	public void favorBook(DTO dto) {
		mapper.favorBook(dto);
	}

}
