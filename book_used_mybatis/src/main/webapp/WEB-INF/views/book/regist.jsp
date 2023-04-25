<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 등록</title>
</head>
<body>
	<h1>책 정보 등록</h1>
	
	<form action="${pageContext.request.contextPath}/book/regist" method="post" >
		<label for="isbn">고유번호</label>
		<input type="text" id="isbn" name="isbn" />
		<br>
		<label for="title">제목</label>
		<input type="text" id="title" name="title" />
		<br>
		<label for="author">저자</label>
		<input type="text" id="author" name="author"  />
		<br>
		<label for="price">가격</label>
		<input type="number" id="price" name="price"  />
		<br>
		<label for="description">설명</label>
		<textarea id="description" name="description">
		</textarea>
		<br>
		<input type="submit" value="등록" >
		<input type="button" value="목록으로 돌아가기" onclick="goList()" >
	</form>
	<script>
		function goList(){
			location.href= "${pageContext.request.contextPath}/book/list"
		}
	</script>
</body>
</html>