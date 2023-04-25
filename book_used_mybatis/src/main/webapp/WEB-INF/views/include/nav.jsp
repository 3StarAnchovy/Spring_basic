<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- root 변수 등록 --%>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
<nav>
	<c:choose>
		<%-- 로그인 하지 않은 경우 --%>
		<c:when test="${empty userInfo }">
			<form action="${root }/user/login" method="post">
				<fieldset>
					<input type="text" name="id"><label>아이디</label> <br>
					<input type="password" name="password"><label>비밀번호</label>
					<br> <input type="submit" value="로그인">
				</fieldset>
			</form>
		</c:when>
		<%-- 로그인 한 경우 --%>
		<c:otherwise>
				${userInfo.id}님 안녕하세요.
				<a href="${root }/user/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</nav>