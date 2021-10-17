<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=UTF-8">
<style type="text/css">
.registerForm {
text-align: center;
}
</style>

<title>Insert title here</title>
</head>
<body>

<form class="registerForm" role="form" action="/board/register" method="post" >
	<div>
		<label>Title</label><input name='title'>
	</div>
	
	<div>
		<label>Text area</label>
		<textarea rows="5" name='content'></textarea>
	</div>
	
	<div>
		<label>Writer</label> <input name='writer'>
	</div>
	
	<button type="submit" >등록</button>
	<button type="list">목록</button>
</form>

<%@ include file="../includes/footer.jsp" %>
</body>
</html>