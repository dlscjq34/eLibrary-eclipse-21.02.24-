<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

	<h1>나의 대출 내역</h1><hr>
	<table border="1">
		<tr> 
			<td> 도서명 </td>
			<td> 대출일 </td>
			<td> 반납예정일 </td>
			<td> 반납일 </td>
			<td> 연체내역 </td>
			<td> 반납하기 </td>
			
		</tr>
		<c:forEach items="${ rents }" var="rents" varStatus="status">
			<tr> 
	 			<td> ${ rents.bookName }</td>
	 			<td> ${ rents.rentDate } </td>
	 			<td> ${ rents.dueDate } </td>
	 			<td> ${ rents.returnDate } </td>
	 			<td> 
					<c:if test="${ rents.lateDate gt 0 }">
						${ rents.lateDate }일 
					</c:if>
	 			</td>
	 			<td>
	 				<c:if test="${ empty rents.returnDate }">
 						<button id="backRent" onclick="backRent('${ rents.rentId }', '${ rents.bookId }')">반납</button>
	 				</c:if> 
	 			</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
