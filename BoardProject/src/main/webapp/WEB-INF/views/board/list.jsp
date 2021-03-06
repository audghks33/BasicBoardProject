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

#modal{
	display:none;
	position: absolute;
	top: 0; left: 0; 
	width: 20%; height: 20%;
	z-index: 1; /* Sit on top */
	background-color: white; /* Fallback color */
	border-style:solid;
	
	left: 50%;
    top: 50%;

</style>

<title>Insert title here</title>
</head>
<body>
<div>
	<h1>ListPage</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>글 번호호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
		</thead>
		
		<c:forEach items="${list}" var="board">
			<tr>
				<td><c:out value="${board.bno}" /></td>
				<td><a class='move' href='<c:out value="${board.bno}" /> '>
				<c:out value="${board.title}" /></a></td>
				<td><c:out value="${board.writer}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" 
				value="${board.regdate}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" 
				value="${board.updateDate}"/></td>
			<tr>
		</c:forEach>
	</table>
	<button id="btnRegist">글쓰기</button>
</div>
<div>

<table>
	<tr>
		<td>
			<c:if test="${pageMaker.prev}">
				<a href="${pageMaker.startPage -1}" class="Previous_button">Previous</a>
			</c:if>
		</td>
	
	
		<c:forEach var="num" begin = "${pageMaker.startPage}" end="${pageMaker.endPage}" >
			<td class="paginate_button ${pageMaker.cri.pageNum == num ? "active":"" } " ><a href="${num}" class="paginate_button">${num}</a></td>
		</c:forEach>

		<td>
			<c:if test="${pageMaker.next}">
				<a href="${pageMaker.endPage +1}" class="Next_button">Next</a>
			</c:if>
		</td>
	</tr>
</table>
	<form id= 'actionForm' action="/board/list" method ='get'>
		<input type="hidden" name='pageNum' value="${pageMaker.cri.pageNum}">
		<input type="hidden" name='amount' value="${pageMaker.cri.amount}">
	</form>
</div>



<!-- 모달창 -->
<div aria-hidden="true" id="modal" >
	<button type="button" id="X">&times;</button>
	<div class="modal-body"></div>
</div>
<!-- /. 모달창 -->

<script type="text/javascript">
	$(document).ready(function(){
		var register ='<c:out value="${register}" />';
		
/* 		if(register != ""){
		alert(register+"번 게시물로 등록 되었습니다.");
		} */
		
		//모달창
		checkModal(register);
		
		history.replaceState({},null,null);
		//등록-조회-뒤로가기 시 팝업 안뜨게
		
		function checkModal(register){
		
			if(register === '' || history.state){
				return;
			}
			
			if(register != ""){
				$(".modal-body").html(register +"번 처리가 완료 되었습니다.");
				$("#modal").css("display","block");
			}
		}
		
		$('#X').click(function(){
			$("#modal").css("display","none");
		});
		
		$('#btnRegist').click(function(){
			self.location="/board/register";	
		});
		
		var actionForm = $("#actionForm");
		
		$(".paginate_button a").on("click", function(e){
			
			e.preventDefault();
			
			console.log("click");
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
		
		$(".move").on("click", function(e){		
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		});
		
	});
</script>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>