
$(function() {
	 
	//도서 등록//////////////////////////////////////////////////////////
	$("#btnRegBook").click(function() {

		let data= {
			bookName: $("#bookName").val(),
			writer: $("#writer").val(),
			publisher: $("#publisher").val(),
			publiDate: $("#publiDate").val()
		}
		
		// 빈칸체크
		if(data.bookName == "" || data.writer == "" || data.publisher == "" || data.publiDate == 0) {
			alert("빈칸을 입력하세요");
	      	return false;
		}
		
		//도서등록 처리
		$.ajax({
			type: "post",
			url: "/regBook",
			data: JSON.stringify(data),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			//dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function(result) {
			alert("도서가 등록되었습니다.");
			location.replace("/regBookForm");
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
		});//ajax
		
	});//도서 등록
	
	
	
	
	
	
	
	
	
	//도서 검색////////////////////////////////////////////////////////////
	$("#btn-SearchBook").click(function() {
	
		let data= {
			column: $("#column").val(),
			searchBook: $("#searchBook").val()
		}
		
		
		//도서 검색 작업
		$.ajax({
			type: "post",
			url: "/searchBook",
			data: JSON.stringify(data),//js를 json 문자열로
			contentType:"application/json; charset=utf-8",//서버에 데이터를 보낼 때 
			dataType: "json"// 서버에서 응답 줄때 json을 javascript로 변경	
		})
		.done(function(result) {//검색 결과
			htmlStr = "";//비동기 문자열
			
			//검색 결과가 없으면
			if(result == "") {
				htmlStr = "찾으시는 도서가 없습니다."
			}
			//검색 결과가 있으면
			else {
				htmlStr = "<table border='1'>"+
						"<tr>"+
							"<td> 도서번호 </td>"+
							"<td> 도서명 </td>"+
							"<td> 저자 </td>"+
							"<td> 출판사 </td>"+
							"<td> 발행일 </td>"+
							"<td> 상태 </td>"+
						"</tr>";
				$.each(result, function(idx, list) {
					htmlStr += "<tr>"+ 
									"<td>"+ list.bookId +"</td>"+
									"<td>"+ list.bookName +"</td>"+
									"<td>"+ list.writer +"</td>"+
									"<td>"+ list.publisher +"</td>"+
									"<td>"+ getFormatDate(list.publiDate) +"</td>"+
									"<td>"+ list.status +"</td>"+
								"</tr>";
				});
				htmlStr += "</table>"; 
			}
			$(".result").html(htmlStr);//<div class="result">
		}) 
		.fail(function(request, error) {
			alert("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
		});//ajax
		
	});//도서 검색
	
	
	
	
	
	//달력선택////////////////////////////////////////////////////////////////
	$( "#publiDate" ).datepicker({
	    dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
	    nextText: '다음 달',
	    monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	    dayNames: ['일','월','화','수','목','금','토'],
	    dayNamesShort: ['일','월','화','수','목','금','토'],
	    dayNamesMin: ['일','월','화','수','목','금','토'],
	    showMonthAfterYear: true,
	    changeMonth: true,
	    changeYear: true,
	    yearSuffix: '년'
	  });

});//ready





//달력포맷
function getFormatDate(date){
	fmt = new Date(date);
    var year = fmt.getFullYear();              //yyyy
    var month = (1 + fmt.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = fmt.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '-' + month + '-' + day;     
}