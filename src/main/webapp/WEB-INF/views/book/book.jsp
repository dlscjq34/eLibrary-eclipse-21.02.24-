<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script src="/resources/js/book.js"></script>
	
	<h1>도서 정보</h1><hr>
	
	<table>
		<tr> 
			<td>
				<table border="1">
					<tr> 
						<td> 도서번호 </td>
						<td> ${ book.bookId } </td>
					</tr>
					<tr> 
						<td> 도서명 </td>
						<td> ${ book.bookName } </td>
					</tr>
					<tr> 
						<td> 저자 </td>
						<td> ${ book.writer } </td>
					</tr>
					<tr> 
						<td> 출판사 </td>
						<td> ${ book.publisher } </td>
					</tr>
					<tr> 
						<td> 발행일 </td>
						<td> <fmt:formatDate value="${ book.publiDate }" pattern="yyyy-MM-dd"/> </td>
					</tr>
					<tr> 
						<td> 상태 </td>
						<td> ${ book.status } </td>
					</tr>
				</table>
			</td>
			<td style="width: 20px;"></td>
			<td align="center">  
				<input type="button" id="rentBook" value="대출 신청"><br><br>
				<input type="button" id="favorBook" value="관심 도서 등록">
			</td>
		</tr>
	</table>
	<%-- favorBook으로 데이터 전달 --%>
	<input type="hidden" id="memberId" value="${ sessionId }">
	<input type="hidden" id="bookId" value="${ book.bookId }">
	
	
		
</body>
</html>
