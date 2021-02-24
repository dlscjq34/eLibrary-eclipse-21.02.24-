
$(function() {
	
	//관심도서 등록/////////////////////////////////////////////////////
	$("#favorBook").click(function() {
		
		let data= {
			memberId: $("#memberId").val(),
			bookId: $("#bookId").val(),
		}
		
		if(data.memberId== "") {
			alert("로그인 후 이용 바랍니다.");
			return false;
		}
			
		//관심도서등록 처리
		$.ajax({
			type: "post",
			url: "/favorBook",
			data: JSON.stringify(data),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function(result) {//
			
			if(result) {
				alert("관심도서가 등록되었습니다.");
				location.replace("/bookList");
			}
			else {
				alert("이미 등록된 도서입니다.");
			}
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"error : "+error+"\n"+"message : "+request.responseText+"\n");
		});//ajax
		
	}); //관심도서 등록
	
	
	
	
	
	
	
	 
	//도서대출내역/////////////////////////////////////////////////////
	$("#favor").click(function() {
		//post 이동
		document.headerForm.action="/favorList";
		document.headerForm.method="post";
		document.headerForm.submit();
	});
	

});//ready


