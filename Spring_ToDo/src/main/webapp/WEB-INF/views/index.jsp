<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Web MVC</title>
</head>
<body>
<div align="center">
<h3>Spring Web MVC</h3>
    <a href="/list">Todo 보기</a>
    <a href="/write">Todo 작성하기</a>
</div>
</body>
</html>