<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Board Read Page</h1>
	<div>
		<label>게시물번호</label><input name="bnoInput" value="<c:out value='${board.bno }' /> " readonly="readonly" />
	</div>
	<div>
		<label>제목</label><input name="TitleInput" value="<c:out value='${board.title }' /> " readonly="readonly" />
	</div>
	<div>
		<label>내용</label><input name="contentInput" value="<c:out value='${board.content }' /> "  readonly="readonly" />
	</div>
	<div>
		<label>작성자</label><input name="writerInput" value="<c:out value='${board.writer }' /> "  readonly="readonly" />
	</div>

	
	<button data-oper="modify">수정</button>
	<button data-oper="list">목록</button>
	
	<form id="operForm" action="/board/modify" method="get">
		<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}" /> '>
	</form>
	
<script type="text/javascript">
	$(document).ready(function(){
		
		var operForm=$("#operForm");
		
		$("button[data-oper='modify']").on('click',function(e){
			e.preventDefault();
			
			operForm.attr("action","/board/modify").submit();
		});
		
		$("button[data-oper='list']").on('click',function(e){
			e.preventDefault();
			
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list").submit();
			
		});
	});
</script>
</body>
</html>