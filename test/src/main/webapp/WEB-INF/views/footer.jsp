<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<hr>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<a href="${root }">홈으로</a>
&nbsp;
<a href="${root }">출결 이슈 등록</a>
&nbsp;
<a href="${root }/board/list">목록 보기</a>