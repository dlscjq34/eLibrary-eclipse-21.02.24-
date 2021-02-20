<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script src="/resources/js/member.js"></script>
	<script src="/resources/js/rent.js"></script>
</head>
<body>
	<header>
		 <a href="/regBookForm">도서 등록</a> &nbsp;
		 <a href="/bookList">도서 목록</a> &nbsp;

		 <c:choose>
		 	<c:when test="${ not empty sessionId }">
		 		[${ sessionId }님 환영합니다. &nbsp;
		 		
		 		<%-- post 이동 --%>
		 		<form name="headerForm" style="display: inline;">
		 			<%-- 세션 체크용 데이터 --%>
			 		<input type="hidden" name="sessionId" id="sessionId" value="${ sessionId }">
				</form>

			 	<span id="member"><a href="#">나의정보</a></span> &nbsp;
			 	<span id="useHistory"><a href="#">대출내역</a></span> &nbsp;
			 	<span id="logout"><a href="#">로그아웃</a></span>]
			 	
		 	</c:when>
		 	<c:otherwise>
		 		<a href="/loginForm">로그인</a>
		 	</c:otherwise>
		 </c:choose>
		 
		 <hr>
	</header>