<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<h1>나의 정보</h1><hr>
	<table border="1" id="showMember">
		<tr> 
			<td> 아이디 </td>
			<td> ${ member.memberId } </td>
		</tr>
		<tr> 
			<td> 패스워드 </td>
 			<td> ${ member.pswd } </td>
		</tr>
		<tr> 
			<td> 이름 </td>
 			<td> ${ member.memberName } </td>
		</tr>
		<tr> 
			<td> 주소 </td>
 			<td> ${ member.addr } </td>
		</tr>
		<tr> 
			<td> 전화번호 </td>
 			<td> ${ member.tel } </td>
		</tr>
		<tr> 
			<td> 가입일 </td>
 			<td> <fmt:formatDate value="${ member.regDate }" pattern="yyyy-MM-dd"/> </td>
 			
		</tr>
		<tr> 
			<td colspan="2" align="center">
	 			<input type="button" id="modifyStart" value="수정하기">&nbsp;
 			</td>
		</tr>
	</table>
</body>
</html>


	<!-- 수정버튼 클릭 시에만 나타나는 테이블 -->
	<form id="modifyMember">
		<table border="1">
			<tr> 
				<td> 아이디 </td>
				<td> ${ member.memberId } <input type="hidden" id="memberId" value="${ member.memberId }"> </td>
			</tr>
			<tr> 
				<td> 패스워드 </td>
	 			<td> <input type="password" id="pswd"> </td>
			</tr>
			<tr> 
				<td> 이름 </td>
	 			<td> <input type="text" id="memberName" value="${ member.memberName }"> </td>
			</tr>
			<tr> 
				<td> 주소 </td>
	 			<td> <input type="text" id="addr" value="${ member.addr }"> </td>
			</tr>
			<tr> 
				<td> 전화번호 </td>
	 			<td> <input type="text" id="tel" value="${ member.tel }"> </td>
			</tr>
			<tr> 
				<td colspan="2" align="center">
		 			<input type="button" id="btnModify" value="수정"> &nbsp; 
		 			<input type="reset" value="초기화">
		 			<input type="button" id="showStart" value="취소">
	 			</td>
			</tr>
		</table>
	</form>
