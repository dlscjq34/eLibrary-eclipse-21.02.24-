<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<h1>로그인 페이지</h1><hr>
	
		<table border="1">
			<tr> 
				<td> 아이디 </td>
				<td> <input type="text" id="memberId"> </td>
			</tr>
			<tr> 
				<td> 패스워드 </td>
	 			<td> <input type="password" id="pswd"> </td>
			</tr>
			<tr> 
	 			<td colspan="2" align="center">
		 			<input type="button" value="로그인" id="btn-login">&nbsp;
		 			<input type="button" value="회원 가입" onclick="location.href='/joinForm'">
	 			</td>
			</tr>
		</table>
	
</body>
</html>
