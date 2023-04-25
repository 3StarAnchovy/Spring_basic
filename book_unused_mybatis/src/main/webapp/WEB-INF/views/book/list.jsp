<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var ="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>책 목록</title>
	<link rel="stylesheet" href="${root }/css/list.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>	
	<h1>책 목록 페이지</h1>
	<form action="${root}/book/delete" method="post">
		<table>
			<tr>
				<th>고유번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td onclick="goDetail('${book.isbn}')">${book.isbn}</td>
					<td onclick="goDetail('${book.isbn}')">${book.title}</td>
					<td onclick="goDetail('${book.isbn}')">${book.author }</td>
					<td onclick="goDetail('${book.isbn}')">${book.price }</td>
					<td onclick="goDetail('${book.isbn}')"><input type="checkbox" name="isbn" value="${book.isbn}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="체크된 책 정보 삭제" />
	</form>
	<script>
		function goDetail(isbn){
			location.href="${pageContext.request.contextPath}/book/detail?isbn="+isbn;
		}
	</script>
</body>
</html>