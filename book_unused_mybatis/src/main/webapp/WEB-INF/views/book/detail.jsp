<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var ="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>책 상세 페이지</title>
	<link rel="stylesheet" href="${root }/css/list.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>	
	<h1>책 상세 페이지</h1>
	<table>
		<tr>
			<th>고유번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
			<th>삭제</th>
			<th>설명</th>
		</tr>
		<tr>
			<td>${book.isbn}</td>
			<td>${book.title}</td>
			<td>${book.author }</td>
			<td>${book.price }</td>
			<td>${book.description }</td>
		</tr>
	</table>
</body>
</html>