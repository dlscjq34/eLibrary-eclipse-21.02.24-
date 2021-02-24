package com.e.library.dao;

import java.util.List;

import com.e.library.model.BookVO;
import com.e.library.model.DTO;
import com.e.library.model.FavorBookVO;
import com.e.library.model.RentVO;

public interface FavorBookDAO {

	public void favorBook(FavorBookVO favorBookV);//관심도서 등록
	
	public List<BookVO> getFavorBooks(String memberId);//관심도서 목록
	
	public FavorBookVO getFavorBook(FavorBookVO favorBookVO);//관심도서 찾기

}
