<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>도시 정보 조회</h1>
	
	<table>
		<c:forEach var = "city" items ="${cityList }">
			<tr>
				<td>${city.name }</td>
				<td>${city.population }</td>
			</tr>
		
		</c:forEach>
	</table>
</body>
</html>
