<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:set var ="root" value="${pageContext.request.contextPath}" ></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>차 상세 페이지</title>
	<link rel="stylesheet" href="${root }/css/list.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>	
	<h1>차 상세 페이지</h1>
	<table>
		<tr>
			<th>차 번호</th>
			<th>모델</th>
			<th>가격</th>
			<th>브랜드</th>
		</tr>
		<tr>
			<td>${car.number}</td>
			<td>${car.model}</td>
			<td>${car.price }</td>
			<td>${car.brand }</td>
		</tr>
	</table>
</body>
</html>