<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자동차 정보 등록</title>
</head>
<body>
    <h1>자동차 정보 등록</h1>
    
    <form action="${pageContext.request.contextPath}/car/regist" method="post" >
        <label for="isbn">number</label>
        <input type="text" id="number" name="number" />
        <br>
        <label for="title">model</label>
        <input type="text" id="model" name="model" />
        <br>
        <label for="price">price</label>
        <input type="text" id="price" name="price"  />
        <br>
        <label for="descr">brand</label>
        <input type="text" id="brand" name="brand"  />
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