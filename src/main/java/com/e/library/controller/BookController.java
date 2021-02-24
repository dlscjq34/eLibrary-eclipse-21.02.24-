package com.e.library.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e.library.model.BookVO;
import com.e.library.model.DTO;
import com.e.library.service.BookServiceImpl;

@Controller
public class BookController {
	
	@Autowired
	private BookServiceImpl service;
	
	
	//도서등록 폼
	@GetMapping("/regBookForm")
	public String regBook() {
		
		return "admin/regBook";
	}
	
	
	
	//도서등록 처리
	@ResponseBody
	@PostMapping("/regBook")
	public void idCheck(@RequestBody BookVO bookVO) {

		bookVO.setStatus("대출 가능");
		service.insert(bookVO);
	}
	
	
	
	//도서목록
	@GetMapping("/bookList")
	public String bookList(Model model) {
		
		List<BookVO> list = service.getAllBooks();
		model.addAttribute("list", list);
		
//		페이징 작업 준비 중
//		int rowCount = 3;
//		int totalRow = list.size();
//		int indexSize = 3;
//		int firstIndex = 0;
//		int lastIndex = firstIndex+indexSize-1;
//		int finalLastIndex;
		
		return "book/bookList";
	}
	
	
	
	
	
	
	//신간도서
	@GetMapping("newBookList")
	public String newBookList(Model model) {
		
		List<BookVO> list = service.getNewBooks();
		model.addAttribute("list", list);
		
		
		return "book/newBookList";
	}
	
	
	
	//도서보기
	@GetMapping("/book")
	public String idCheck(String bookId, Model model) {

		model.addAttribute("book", service.getBook(bookId));
		
		return "/book/book";
		
	}
	
	
	
	//관심 도서 등록
	@GetMapping("/favorBook")
	public String favorBook(DTO dto, Model model) {

		System.out.println(dto);
		
		
		return "/book/book";
		
	}
	
	
	
	
	
	
	//도서 검색
	@ResponseBody
	@PostMapping("/searchBook")
	public List<BookVO> searchBook(@RequestBody Map<String, String> map) {

		return service.getBooks(map);
	}
	
	
	
	//안드로이드 도서검색
	@PostMapping("/androidSearchBook")
	public void androidSearchBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", request.getParameter("column"));
		map.put("searchBook", request.getParameter("searchBook"));
		
		List<BookVO> bookList = service.getBooks(map);
		
		JSONArray jArray = new JSONArray();
		for (int i = 0; i < bookList.size(); i++) {
			JSONObject jsonRow = new JSONObject();
			jsonRow.put("bookId", bookList.get(i).getBookId());
			jsonRow.put("bookName", bookList.get(i).getBookName());
			jsonRow.put("writer", bookList.get(i).getWriter());
			jsonRow.put("publisher", bookList.get(i).getPublisher());
			jsonRow.put("publiDate", new SimpleDateFormat("yyyy-MM-dd").format(bookList.get(i).getPubliDate()));//시분초에서 : 와 .이 json 유효성 검사에 위반됨. 그래서 시분초 뺐다. 
			jsonRow.put("status", bookList.get(i).getStatus());
			jArray.add(jsonRow);
		}
		
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result", jArray);
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
	}
	

	
	
	
	
	
	

	
}
