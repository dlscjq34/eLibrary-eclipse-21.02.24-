<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<script src="/resources/js/book.js"></script>
	
	<h1>관심도서 목록</h1><hr>
	<table border="1">
		<tr> 
			<td> 도서번호 </td>
			<td> 도서명 </td>
			<td> 저자 </td>
			<td> 출판사 </td>
			<td> 발행일 </td>
			<td> 상태 </td>
		</tr>

		<c:forEach items="${ list }" var="list">
			<tr> 
				<td> ${ list.bookId } </td>
				<td> 
					<a href="/book?bookId=${ list.bookId }">${ list.bookName }</a>
				</td>
				<td> ${ list.writer } </td>
				<td> ${ list.publisher } </td>
				<td> <fmt:formatDate value="${ list.publiDate }" pattern="yyyy-MM-dd"/> </td>
				<td> ${ list.status } </td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
