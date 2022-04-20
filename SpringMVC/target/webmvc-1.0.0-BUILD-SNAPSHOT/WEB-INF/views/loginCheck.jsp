<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container text-center">
		<c:if test="${ empty id}">
			<a href="loginForm">로그인</a>
			<br>
		</c:if>

		<c:if test="${!empty id}">
			${id }님 로그인 되었습니다.
			<a href="/logout">로그아웃</a>
	<br>
		</c:if>
	</div>
</body>
</html>