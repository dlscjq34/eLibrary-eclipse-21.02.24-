
$(function() {
	
	//도서 대출/////////////////////////////////////////////////////
	$("#rentBook").click(function() {
		
		let data= {
			memberId: $("#memberId").val(),
			bookId: $("#bookId").val(),
		}
		
		if(data.memberId== "") {
			alert("로그인 후 이용 바랍니다.");
			return false;
		}
			
		//대출 처리
		$.ajax({
			type: "post",
			url: "/rent",
			data: JSON.stringify(data),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function(result) {//
			
			if(result) {
				alert("대출이 완료되었습니다.");
				location.replace("/bookList");
			}
			else {
				alert("관 외 대출 중입니다.");
			}
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
		});//ajax
		
	}); //도서 대출
	
	
	
	
	
	//도서대출내역/////////////////////////////////////////////////////
	$("#useHistory").click(function() {
		goUseHistory();
	});
	
	
	
	//대출 반납///////////////////////////////////////////////////////////////
	$("#backRent").click(function() {
		backRent(rentId, bookId);	
	});
	
	
});//ready






//대출 반납////////////////////////////////////////////////////////////////
function backRent(rentId, bookId) {
	
	if(!confirm("정말 반납하시겠습니까?"))
		return false;
		
	let data= {
			rentId, 
			bookId
	}
	
	//대출 반납 
	$.ajax({
		type: "post",
		url: "/backRent",
		data: JSON.stringify(data),//js를 json 문자열로
		contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
		//dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
	})
	.done(function() {//
		alert("반납 되었습니다.");
		goUseHistory();
		
	}) 
	.fail(function(request, error) {
		alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
	});//ajax
	
} //대출 반납








//도서대출내역/////////////////////////////////////////////////////
function goUseHistory() {
	//post 이동
	document.headerForm.action="/useHistory";
	document.headerForm.method="post";
	document.headerForm.submit();
}
