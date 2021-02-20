package com.e.library.service;

import java.util.List;
import java.util.Map;

import com.e.library.model.BookVO;
import com.e.library.model.MemberVO;

public interface BookService {
	
	public void insert(BookVO bookVO);//도서 등록
	
	public BookVO getBook(String bookId);//도서 찾기
	
	public List<BookVO> getBooks(Map<String, String> map);//모든 도서 검색
	
	public List<BookVO> getAllBooks();//모든 도서
	
	public int getBookCount();//모든 도서 수

}
