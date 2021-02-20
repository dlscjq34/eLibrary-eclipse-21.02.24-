package com.e.library.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.e.library.mapper.BookMapper;
import com.e.library.model.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private BookMapper mapper;
	

	@Override
	public void insert(BookVO bookVO) {
		mapper.insert(bookVO);

	}

	@Override
	public List<BookVO> getBooks(Map<String, String> map) {
		return mapper.getBooks(map);
	}

	@Override
	public List<BookVO> getAllBooks() {
		return mapper.getAllBooks();
	}
	
	@Override
	public int getBookCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookVO getBook(String bookId) {
		return mapper.getBook(bookId);
	}


}
