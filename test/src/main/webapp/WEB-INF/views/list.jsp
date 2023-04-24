<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: gray;
}

th, td {
	border: 1px dotted black;
	text-align: center;
}

#selectedDel {
	text-align: right;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1 id="head">출결 관리 - 리스트</h1>
	<form action = "${root }/board/delete" method = "post">
		<table>
			<tr>
				<th>이슈번호</th>
				<th>아이디</th>
				<th>날짜</th>
				<th>사유</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td><a href = "${root }/board/detail?ano=${board.ano}">${board.ano }</a></td>
					<td>${board.userid}</td>
					<td>${board.issuedate }</td>
					<td>${board.issue }</td>
					<td><input type="checkbox" name="ano" value="${board.ano}"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="체크된 책 정보 삭제">
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>