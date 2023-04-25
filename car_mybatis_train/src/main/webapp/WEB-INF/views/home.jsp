<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- root 변수 등록 --%>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
	<h1>
		메인 페이지
	</h1>
	<ul>
		<li><a href="${root}/car/list">차 목록 조회</a></li>
		<li><a href="${root}/car/regist-page">차 등록</a></li>
	</ul>
	<c:if test="${not empty msg}">
		<script>
			alert("${msg}")
		</script>
	</c:if>
</body>
</html>
