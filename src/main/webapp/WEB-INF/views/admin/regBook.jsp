<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script src="/resources/js/book.js"></script>

	<h1>도서 등록 페이지</h1><hr>
	<form>
		<table border="1">
			<tr> 
				<td> 제목 </td>
				<td> <input type="text" id="bookName"> </td>
			</tr>
			<tr> 
				<td> 저자 </td>
	 			<td> <input type="text" id="writer"> </td>
			</tr>
			<tr> 
				<td> 출판사 </td>
	 			<td> <input type="text" id="publisher"> </td>
			</tr>
			<tr> 
				<td> 발행일 </td>
	 			<td> <input type="text" id="publiDate"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
		 			<input type="button" id="btnRegBook" value="도서 등록">&nbsp;
		 			<input type="reset" value="초기화">
	 			</td>
			</tr>
		</table>
	</form>
</body>
</html>
