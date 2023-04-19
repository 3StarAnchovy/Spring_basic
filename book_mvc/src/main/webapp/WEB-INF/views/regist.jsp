<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 등록</title>
</head>
<body>
    <h1>도서 정보 등록</h1>
    
    <form action="${pageContext.request.contextPath}/registAction" method="post" >
        <label for="isbn">isbn</label>
        <input type="text" id="isbn" name="isbn" />
        <br>
        <label for="title">title</label>
        <input type="text" id="title" name="title" />
        <br>
        <label for="price">price</label>
        <input type="text" id="price" name="price"  />
        <br>
        <label for="descr">descr</label>
        <input type="text" id="descr" name="descr"  />
        <br>
        <label for="author">author</label>
        <input type="text" id="author" name="author"  />
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