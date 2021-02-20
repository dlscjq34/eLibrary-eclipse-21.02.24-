package com.e.library.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e.library.model.MemberVO;
import com.e.library.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl service;
	
	//메인(로그인 폼)
	@GetMapping("/loginForm")
	public String home() {
		
		return "member/login";
	}
	
	
	//회원가입 폼
	@GetMapping("/joinForm")
	public String joinForm() {
		
		return "member/join";
	}
	
	
	//회원가입 
	@ResponseBody
	@PostMapping("/idCheck")
	public boolean idCheck(@RequestBody MemberVO memberVO) {
		
		MemberVO existingVO = service.getMember(memberVO.getMemberId());//아이디로 검색
		
		if(existingVO == null) {//중복 아이디가 없으면 회원 가입
			memberVO.setMemberRole("USER");
			service.insert(memberVO);
			return true;
		}
		else {//중복아이디가 있으면 가입 실패
			return false;
		}
	}
	
	
	
	
	//안드로이드 회원가입 
	@PostMapping("/androidJoin")
	public void androidJoin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//회원가입 정보 담기
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(request.getParameter("memberId")); 
		memberVO.setPswd(request.getParameter("pswd")); 
		memberVO.setMemberName(request.getParameter("memberName")); 
		memberVO.setAddr(request.getParameter("addr")); 
		memberVO.setTel(request.getParameter("tel")); 
		memberVO.setMemberRole("USER");
		MemberVO existingVO = service.getMember(memberVO.getMemberId());
		
		JSONObject json = new JSONObject();//json 객체 준비
		
		if(existingVO == null) {////중복 아이디가 없으면 회원 가입
			service.insert(memberVO);
			json.put("result", "회원가입 되었습니다.");
		}
		else {//중복아이디가 없으면 로그인 실패
			json.put("result", "아이디와 비밀번호를 다시 확인해주세요.");
		}
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	
	
	//로그인 
	@ResponseBody
	@PostMapping("/login")
	public boolean login(@RequestBody MemberVO memberVO, HttpServletRequest request) {
		
		System.out.println(memberVO);
		
		MemberVO existingVO = service.loginCheck(memberVO.getMemberId(), memberVO.getPswd());//아이디로 검색
		
		if(existingVO != null) {//중복 아이디가 있으면 로그인
			request.getSession().setAttribute("sessionId", existingVO.getMemberId());//세션에 아이디 저장
			return true;
		}
		else {//중복아이디가 없으면 로그인 실패
			return false;
		}
		
	}
	
	
	
	//안드로이드 로그인 
	@PostMapping("/androidLogin")
	public void androidLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//아이디로 검색
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(request.getParameter("memberId")); 
		MemberVO existingVO = service.getMember(memberVO.getMemberId());
		
		JSONObject json = new JSONObject();//json 객체 준비
		PrintWriter out = response.getWriter();
		
		if(existingVO != null) {//중복 아이디가 있으면 로그인
			json.put("memberId", existingVO.getMemberId());
			json.put("pswd", existingVO.getPswd());
			json.put("memberName", existingVO.getMemberName());
			json.put("addr", existingVO.getAddr());
			json.put("tel", existingVO.getTel());
			json.put("regDate", new SimpleDateFormat("yyyy-MM-dd").format(existingVO.getRegDate()));//시분초에서 : 와 .이 json 유효성 검사에 위반됨. 그래서 시분초 뺐다.
			out.print(json);
		}
		else {
			json.put("memberId", "empty");
			out.print(json);
		}
	}
	
	
	
	//로그아웃 
	@ResponseBody
	@PostMapping("/logout")
	public void logout(@RequestBody String sessionId, HttpServletRequest request) {
		
		if(sessionId != null) 
			request.getSession().invalidate();//초기화
	}
	
	
	
	
	//나의 정보
	@PostMapping("/member")
	public String member(String sessionId, Model model) {
		model.addAttribute("member", service.getMember(sessionId)); 
		return "member/member";
	}
	
	
	
	
	
	//나의 정보 수정 
	@ResponseBody
	@PostMapping("/updateMember")
	public void updateMember(@RequestBody MemberVO memberVO) {
		service.updateMember(memberVO);
	}
	
	
		
	
	//안드로이드 회원정보 수정
	@PostMapping("/androidMemberUpdate")
	public void androidMemberUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//회원정보 담기, 수정
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(request.getParameter("memberId")); 
		memberVO.setPswd(request.getParameter("pswd")); 
		memberVO.setMemberName(request.getParameter("memberName")); 
		memberVO.setAddr(request.getParameter("addr")); 
		memberVO.setTel(request.getParameter("tel")); 
		service.updateMember(memberVO);
		
		//수정된 정보 보내기
		MemberVO existingVO = service.getMember(memberVO.getMemberId());
		JSONObject json = new JSONObject();
		json.put("memberId", existingVO.getMemberId());
		json.put("pswd", existingVO.getPswd());
		json.put("memberName", existingVO.getMemberName());
		json.put("addr", existingVO.getAddr());
		json.put("tel", existingVO.getTel());
		json.put("regDate", new SimpleDateFormat("yyyy-MM-dd").format( existingVO.getRegDate()));//시분초에서 : 와 .이 json 유효성 검사에 위반됨. 그래서 시분초 뺐다.
		json.put("result", "수정 처리되었습니다.");
		
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
}
