<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
</head>
<body>
	<h1>책 목록 페이지</h1>
	<form action="${root }/car/delete" method="post">
		<table>
			<tr>
				<th>고유번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>

			<tr>
				<td>${car.number }</td>
				<td>${car.model}</td>
				<td>${car.price }</td>
				<td>${car.brand }</td>
				<td><input type="checkbox" name="number" value="${car.number}"></td>
			</tr>
		</table>
		<input type="submit" value="체크된 책 정보 삭제">
	</form>


	<a href="${pageContext.request.contextPath }"> 홈 </a>
</body>
</html>