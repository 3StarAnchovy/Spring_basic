<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도시 정보 등록</title>
</head>
<body>
    <h1>도시 정보 등록</h1>
    
    <form action="${pageContext.request.contextPath}/city/regist" method="post" >
        <label for="name">도시명</label>
        <input type="text" id="name" name="name" />
        <br>
        <label for="district">지역</label>
        <input type="text" id="district" name="district" />
        <br>
        <label for="population">인구</label>
        <input type="number" id="population" name="population"  />
        <br>
        <input type="submit" value="등록" >
        <input type="button" value="목록으로 돌아가기" onclick="goList()" >
    </form>
    <script>
        function goList(){
            location.href= "${pageContext.request.contextPath}/city/list-page"
        }
    </script>
</body>
</html>
```