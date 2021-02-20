package com.e.library.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.library.dao.BookDAOImpl;
import com.e.library.model.BookVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAOImpl dao; 

	@Override
	public void insert(BookVO bookVO) {
		dao.insert(bookVO);
	}

	@Override
	public List<BookVO> getBooks(Map<String, String> map) {
		return dao.getBooks(map);
	}

	@Override
	public List<BookVO> getAllBooks() {
		return dao.getAllBooks();
	}
	
	@Override
	public int getBookCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookVO getBook(String bookId) {
		return dao.getBook(bookId);
	}


}
