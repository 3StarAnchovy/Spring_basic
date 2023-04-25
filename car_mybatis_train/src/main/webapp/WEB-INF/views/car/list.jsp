<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차 목록</title>
<link rel="stylesheet" href="${root }/css/list.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<h1>차 목록 페이지</h1>
	<form action="${root}/car/delete" method="post">
		<table>
			<tr>
				<th>차 번호</th>
				<th>모델</th>
				<th>가격</th>
				<th>브랜드</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${carList}" var="car">
				<tr>
					<td onclick="goDetail('${car.number}')">${car.number}</td>
					<td onclick="goDetail('${car.number}')">${car.model}</td>
					<td onclick="goDetail('${car.number}')">${car.price }</td>
					<td onclick="goDetail('${car.number}')">${car.brand }</td>
					<td><input type="checkbox" name="number" value="${car.number}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="체크된 차 정보 삭제" />
	</form>
	<script>
		function goDetail(number) {
			location.href = "${pageContext.request.contextPath}/car/detail?number="
					+ number;
		}
	</script>
</body>
</html>