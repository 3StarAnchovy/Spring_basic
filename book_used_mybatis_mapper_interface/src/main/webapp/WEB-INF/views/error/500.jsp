<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500에러 페이지</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
	<h1>${msg}</h1>
	<a href="${pageContext.request.contextPath}">홈</a>
</body>
</html>