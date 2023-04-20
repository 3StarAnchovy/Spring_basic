<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<c:set value="${pageContext.request.contextPath }" var="root"></c:set>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<ul>
		<li><a href="${root }/book/list">책 목록 조회</a></li>
		<li><a href="${root }/book/registPage">책 등록</a></li>
	</ul>
</body>
</html>
