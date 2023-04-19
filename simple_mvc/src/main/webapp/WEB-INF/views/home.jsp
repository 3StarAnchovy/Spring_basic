<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>메인페이지</h1>
	<a href = "${pageContext.request.contextPath }/city/list-pages">도시목록</a>
	<a href = "${pageContext.request.contextPath }/city/regist-page">도시정보등록</a>
</body>
</html>
