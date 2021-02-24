package com.e.library.mapper;

import java.util.List;

import com.e.library.model.BookVO;
import com.e.library.model.DTO;
import com.e.library.model.FavorBookVO;
import com.e.library.model.RentVO;

public interface FavorBookMapper {
	
	
	public void favorBook(FavorBookVO favorBookVO);//관심도서 등록
	
	public List<BookVO> getFavorBooks(String memberId);//관심도서 목록
	
	public FavorBookVO getFavorBook(FavorBookVO favorBookVO) ;//관심도서 찾기
	
	
	
}
