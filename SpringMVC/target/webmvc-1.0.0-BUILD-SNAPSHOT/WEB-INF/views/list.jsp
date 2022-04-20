<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container text-center">
	<img src="resources/image/f1.jpg"/>
	<h1>JSP 게시판</h1>
	<jsp:include page="loginCheck.jsp" />

	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="row">
				<tr>
					<td>${row.num }</td>
					<td><a href="/read?num=${row.num}">${row.title }</a></td>
					<td>${row.name }</td>
					<td>${row.wdate }</td>
					<td>${row.count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/insertForm">새글쓰기</a>
	<br><br>
	</div>
</body>
</html>



