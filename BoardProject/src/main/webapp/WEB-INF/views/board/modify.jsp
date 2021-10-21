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

<h1>Board modify Page</h1>
<form role="form"  action="/board/modify" method="post">
	<div>
		<label>게시물번호</label><input name="bno" value="<c:out value='${board.bno }' /> " readonly="readonly "/>
	</div>
	<div>
		<label>제목</label><input name="title" value="<c:out value='${board.title }' /> " />
	</div>
	<div>
		<label>내용</label><input name="content" value="<c:out value='${board.content }' /> " />
	</div>
	<div>
		<label>작성자</label><input name="writer" value="<c:out value='${board.writer }' /> " />
	</div>
	<div>
		<label>등록일자</label><input name='regDate' value='<fmt:formatDate pattern="yyyy/MM/dd" 
				value="${board.regdate}" />' readonly="readonly" />
	</div>
	<div>
		<label>변경일자</label><input name='updateDate' value='<fmt:formatDate pattern="yyyy/MM/dd" 
				value="${board.updateDate}" />' readonly="readonly" />
	</div>
	
	<button type="submit" data-oper="modify" >수정</button>
	<button type="submit" data-oper="remove">삭제</button>
	<button type="submit" data-oper="list">목록</button>
</form>

<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj=$("form");
		
		$("button").on("click", function(e){
			e.preventDefault(); // form 기능을 상실시킴
			
			var operation =$(this).data("oper");
			
			if(operation === 'remove'){
				formObj.attr("action","/board/remove")
			}else if(operation === 'list'){
				formObj.attr("action","/board/list").attr("method","get");
				formObj.empty();
			}
			formObj.submit();
		});
	});
</script>
</body>
</html>