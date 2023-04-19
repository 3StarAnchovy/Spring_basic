<%@ page contentType="text/html; charset=utf-8" %>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	도서 정보 시스템  
</h1>
<a href = "${pageContext.request.contextPath }/list">도서 목록 조회</a>
<a href = "${pageContext.request.contextPath }/regist">도서 등록</a>
</body>
</html>
