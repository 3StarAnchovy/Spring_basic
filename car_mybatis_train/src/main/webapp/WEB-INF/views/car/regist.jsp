<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<model>차 정보 등록</model>
</head>
<body>
	<h1>차 정보 등록</h1>
	
	<form action="${pageContext.request.contextPath}/car/regist" method="post" >
		<label for="number">고유번호</label>
		<input type="text" id="number" name="number" />
		<br>
		<label for="model">제목</label>
		<input type="text" id="model" name="model" />
		<br>
		<label for="price">가격</label>
		<input type="number" id="price" name="price"  />
		<br>
		<label for="brand">브랜드</label>
		<input type="text" id="brand" name="brand" />
		<br>
		<input type="submit" value="등록" >
		<input type="button" value="목록으로 돌아가기" onclick="goList()" >
	</form>
	<script>
		function goList(){
			location.href= "${pageContext.request.contextPath}/car/list"
		}
	</script>
</body>
</html>