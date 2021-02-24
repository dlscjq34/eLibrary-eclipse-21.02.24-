package com.e.library.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e.library.model.BookVO;
import com.e.library.model.FavorBookVO;
import com.e.library.service.FavorBookServiceImpl;

@Controller
public class FavorBookController {
	
	@Autowired
	private FavorBookServiceImpl service;
	
	
	//관심도서등록 
	@ResponseBody
	@PostMapping("/favorBook")
	public boolean favorBook(@RequestBody FavorBookVO favorBookVO) {
		
		//중복검사 및 등록 트랜잭션 결과가 boolean으로 넘어옴
		return service.favorBook(favorBookVO);
	}
	
	
	
	//안드로이드 관심도서 등록
	@PostMapping("/androidFavorBook")
	public void androidFavorBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//중복검사 및 등록 트랜잭션 결과가 boolean으로 넘어옴
		FavorBookVO favorBookVO = new FavorBookVO();
		favorBookVO.setMemberId(request.getParameter("memberId"));
		favorBookVO.setBookId(request.getParameter("bookId"));
		boolean result = service.favorBook(favorBookVO);
		
		//안드로이드행 메시지
		JSONObject json = new JSONObject();//json 객체 준비
		if(result)
			json.put("result", "관심도서가 등록되었습니다.");
		else
			json.put("result", "이미 등록된 도서입니다.");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	
	
	//관심도서목록
	@PostMapping("/favorList")
	public String favor(String sessionId, Model model) {
		
		//해당멤버 정보로 검색(favorBook 테이블의 memberId를 통해 book 테이블과 조인)
		List<BookVO> list = service.getFavorBooks(sessionId);
		model.addAttribute("list", list);
		
		return "favor/favorList";
	}
	
	
	
	
	//안드로이드 관심도서 목록
	@PostMapping("/androidFavorList")
	public void androidFavorList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//관심도서 검색
		String sessionId = request.getParameter("memberId");
		List<BookVO> favorList = service.getFavorBooks(sessionId);
		
		//검색 결과를 json 변환
		JSONArray jArray = new JSONArray();
		for (int i = 0; i < favorList.size(); i++) {
			JSONObject jsonRow = new JSONObject();
			jsonRow.put("bookId", favorList.get(i).getBookId());
			jsonRow.put("bookName", favorList.get(i).getBookName());
			jsonRow.put("writer", favorList.get(i).getWriter());
			jsonRow.put("publisher", favorList.get(i).getPublisher());
			jsonRow.put("publiDate", new SimpleDateFormat("yyyy-MM-dd").format(favorList.get(i).getPubliDate()));//시분초에서 : 와 .이 json 유효성 검사에 위반됨. 그래서 시분초 뺐다.
			jsonRow.put("status", favorList.get(i).getStatus());
			jArray.add(jsonRow);
		}
		
		//안드로이드로 전달
		JSONObject jsonObj = new JSONObject();//json 객체 준비
		jsonObj.put("result", jArray);
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
	}
	
}
