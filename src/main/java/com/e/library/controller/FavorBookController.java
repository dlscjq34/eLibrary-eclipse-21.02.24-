package com.e.library.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e.library.model.DTO;
import com.e.library.service.FavorBookServiceImpl;

@Controller
public class FavorBookController {
	
	@Autowired
	private FavorBookServiceImpl service;
	
	
	//관심도서등록 
	@ResponseBody
	@PostMapping("/favorBook")
	public boolean favorBook(@RequestBody DTO dto) {
		
		service.favorBook(dto);
		
		return true;
	}
	
	
	
	//안드로이드 관심도서 등록
	@PostMapping("/androidFavorBook")
	public void androidFavorBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DTO dto = new DTO();
		dto.setMemberId(request.getParameter("memberId"));
		dto.setBookId(request.getParameter("bookId"));
		
		service.favorBook(dto);
		
		JSONObject json = new JSONObject();//json 객체 준비
		json.put("result", "등록 완료");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
}
