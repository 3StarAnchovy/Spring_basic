<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>도시 정보조회</h1>

	<table>
		<c:forEach var = "book" items ="${bookList}">
			<tr>
				<td>${book.title}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>