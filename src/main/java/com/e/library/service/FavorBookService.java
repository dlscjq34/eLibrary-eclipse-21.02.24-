package com.e.library.service;

import org.springframework.stereotype.Service;

import com.e.library.model.DTO;

@Service
public interface FavorBookService {
	
	public void favorBook(DTO dto);//관심도서 등록

}
