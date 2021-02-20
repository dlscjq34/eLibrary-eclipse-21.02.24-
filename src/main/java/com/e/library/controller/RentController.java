package com.e.library.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
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
import com.e.library.model.DTO;
import com.e.library.model.RentVO;
import com.e.library.service.RentServiceImpl;

@Controller
public class RentController {
	
	@Autowired
	private RentServiceImpl service;
	
	//대출 
	@ResponseBody
	@PostMapping("/rent")
	public boolean rent(@RequestBody DTO dto) {
		
		//맵퍼에서 도서번호는 있으나 반납일이 없는 도서 검색
		RentVO rent = service.getRent(dto.getBookId()); 
		if (rent != null) {
			return false;
		}
		//검색결과가 없다면 대출이력 없거나, 대출이력이 있으나 반납을 했다는 것임
		else {
			service.rent(dto);//대출 등록
			return true;
		}
	}
	
	
	
	//안드로이드 대출 
	@PostMapping("/androidRent")
	public void andRoidRent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String memberId = request.getParameter("memberId");
		String bookId = request.getParameter("bookId");
		DTO dto = new DTO();
		dto.setMemberId(memberId);
		dto.setBookId(bookId);
		
		JSONObject jsonObj = new JSONObject();
		
		//맵퍼에서 도서번호는 있으나 반납일이 없는 도서 검색
		RentVO rent = service.getRent(dto.getBookId()); 
		if (rent != null) {
			jsonObj.put("result", "이미 대출된 도서입니다.");
		}
		//검색결과가 없다면 대출이력 없거나, 대출이력이 있으나 반납을 했다는 것임
		else {
			service.rent(dto);//대출 등록
			jsonObj.put("result", "신청되었습니다.");
		}
		
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
	}
	
	
	
	
	
	//도서대출내역 
	@PostMapping("/useHistory")
	public String useHistory(String sessionId, Model model) {
		
		
		model.addAttribute("rents", service.getRents(sessionId));
		
		
		return "rent/useHistory";
	}
	
	
	
	
	
	//안드로이드 도서대출내역 
	@PostMapping("/androidUseHistory")
	public void useHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<DTO> rentList = service.getRents(request.getParameter("memberId"));
		
		
		JSONArray jArray = new JSONArray();
		for (int i = 0; i < rentList.size(); i++) {
			JSONObject jsonRow = new JSONObject();
			jsonRow.put("rentId", rentList.get(i).getBookId());
			jsonRow.put("bookId", rentList.get(i).getBookId());
			jsonRow.put("bookName", rentList.get(i).getBookName());
			jsonRow.put("rentDate", new SimpleDateFormat("yyyy-MM-dd").format(rentList.get(i).getRentDate()));//시분초에서 : 와 .이 json 유효성 검사에 위반됨. 그래서 시분초 뺐다. 
			jsonRow.put("dueDate", new SimpleDateFormat("yyyy-MM-dd").format(rentList.get(i).getDueDate()));//시분초에서 : 와 .이 json 유효성 검사에 위반됨. 그래서 시분초 뺐다. 
			jsonRow.put("lateDate", rentList.get(i).getLateDate());
			jArray.add(jsonRow);
			
			//null이면 빈문자열, 아니면 날짜 대입
			Timestamp returnDate = rentList.get(i).getReturnDate();
			jsonRow.put("returnDate", (returnDate == null)? "":new SimpleDateFormat("yyyy-MM-dd").format(returnDate));//시분초에서 : 와 .이 json 유효성 검사에 위반됨. 그래서 시분초 뺐다.
		}
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result", jArray);
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
	}
	
	
	
	
	
	//대출 반납 
	@ResponseBody
	@PostMapping("/backRent")
	public void backRent(@RequestBody RentVO rentVO) {
		
		service.backRent(rentVO);
	}
}
