package com.e.library.mapper;

import java.util.List;
import java.util.Map;

import com.e.library.model.BookVO;

public interface BookMapper {
	
	public void insert(BookVO bookVO);//도서 등록
	
	public BookVO getBook(String bookId);//도서 찾기
	
	public List<BookVO> getBooks(Map<String, String> map);//모든 도서 검색
	
	public List<BookVO> getAllBooks();//모든 도서
	
	public List<BookVO> getNewBooks();//신간도서
	
	public int getBookCount();//모든 도서 수
	
	
	
	
}
