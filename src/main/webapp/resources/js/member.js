
$(function() {
	
	//회원가입/////////////////////////////////////////////////////
	$("#btn-join").click(function() {
	
		let data= {
			memberId: $("#memberId").val(),
			pswd: $("#pswd").val(),
			memberName: $("#memberName").val(),
			addr: $("#addr").val(),
			tel: $("#tel").val()
		}
		
		// 아이디 입력체크
		if(data.memberId.length < 5) {
			alert("아이디를 5자리 이상 입력하세요");
	      	return false;
		}
		// 비밀번호 입력체크
		else if(data.pswd.length < 5) {
			alert("비밀번호 5자리 이상 입력하세요");
	      	return false;
		}
		// 기타 빈칸체크
		else if(data.memberName == "" || data.addr == "" || data.tel == "") {
			alert("빈칸을 입력하세요");
	      	return false;
		}
		
		//회원 가입 처리
		$.ajax({
			type: "post",
			url: "/idCheck",
			data: JSON.stringify(data),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function(result) {//아이디 중복 여부가 boolean으로 옴
			
			if(result) {
				alert("회원가입이 완료었습니다.");
				location.replace("/loginForm");
			}
			else {
				alert("사용 중인 아이디입니다.");
				return false;		
			}
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
		});//ajax
		
	});//회원가입
	
	
	
	
	
	//로그인///////////////////////////////////////////////////////
	$("#btn-login").click(function() {
	
		let data= {
			memberId: $("#memberId").val(),
			pswd: $("#pswd").val(),
		}
		
		//로그인 처리
		$.ajax({
			type: "post",
			url: "/login",
			data: JSON.stringify(data),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function(result) {//아이디 중복 여부가 boolean으로 옴
			
			if(result) {
				alert("로그인되었습니다.");
				location.replace("/regBookForm");
			}
			else {
				alert("아이디 및 비밀번호를 확인하세요.");
				return false;		
			}
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
		});//ajax
		
	});//로그인
	




	
	//로그아웃/////////////////////////////////////////////////////////
	$("#logout").click(function() {
	
		
		let sessionId= $("#sessionId").val();
		
		//로그아웃 처리
		$.ajax({
			type: "post",
			url: "/logout",
			data: JSON.stringify(sessionId),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			//dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function() {
			alert("로그아웃되었습니다.");
			location.replace("/loginForm");
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
		});//ajax
		
	});//로그아웃
	
	
	
	
	
	//나의정보/////////////////////////////////////////////////////////
	$("#member").click(function() {
		//post 이동
		document.headerForm.action="/member";
		document.headerForm.method="post";
		document.headerForm.submit();
	});
	
	
	
	
	
	//회원정보수정 비동기 화면 전환////////////////////////////////////////
	$("#modifyMember").hide();//수정화면은 일단 숨김(수정버튼 클릭 시 나타남)	
	$("#modifyStart").click(function() {
		$("#showMember").hide();
		$("#modifyMember").show();
	});
	$("#showStart").click(function() {
		$("#showMember").show();
		$("#modifyMember").hide();
	});
	
	
	
	
	
	//회원정보 수정/////////////////////////////////////////////////////
	$("#btnModify").click(function() {
	
		let data= {
			memberId: $("#memberId").val(),
			pswd: $("#pswd").val(),
			memberName: $("#memberName").val(),
			addr: $("#addr").val(),
			tel: $("#tel").val()
		}
		
		// 비밀번호 입력체크
		if(data.pswd.length < 5) {
			alert("비밀번호 5자리 이상 입력하세요");
	      	return false;
		}
		// 기타 빈칸체크
		else if(data.memberName == "" || data.addr == "" || data.tel == "") {
			alert("빈칸을 입력하세요");
	      	return false;
		}
		
		//회원수정 처리
		$.ajax({
			type: "post",
			url: "/updateMember",
			data: JSON.stringify(data),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			//dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function() {
			alert("수정되었습니다.");			
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
		});//ajax
		
	});//회원정보 수정
	
	
	
	
	
	
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
				alert("오류 발생");
			}
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"error : "+error+"\n"+"message : "+request.responseText+"\n");
		});//ajax
		
	}); //관심도서 등록
	
	
	
});//ready
