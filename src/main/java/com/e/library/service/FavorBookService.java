package com.e.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.e.library.model.BookVO;
import com.e.library.model.FavorBookVO;

@Service
public interface FavorBookService {
	
	public boolean favorBook(FavorBookVO favorBookVO);//관심도서 등록
	
	public List<BookVO> getFavorBooks(String memberId);//관심도서 목록

}
