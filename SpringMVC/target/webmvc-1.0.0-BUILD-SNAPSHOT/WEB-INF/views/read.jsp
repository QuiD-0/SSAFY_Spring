<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	<img src="/resources/image/f2.jpg"/>
		<h1>글 읽기</h1>
		<p>
			<jsp:include page="loginCheck.jsp" />
	<br>
			<table class="table table-bordered"><TR>
				<TH>NUM</TH>
				<TD>${b.num }</TD>
				<Th>NAME</TH>
				<TD>${b.name }</TD>
			</TR>
			<TR>
				<TH>DATE</TH>
				<TD>${b.wdate }</TD>
				<TH>COUNT</TH>
				<TD>${b.count }</TD>
			</TR>
			<TR>
				<TH>TITLE</TH>
				<TD COLSPAN=3>${b.title }</TD>
			</TR>
			<TR>
				<TH>CONTENT</TH>
				<TD COLSPAN=3>
				<textarea readonly class="form-control" rows="5" id="comment" name="comment">${b.content }</textarea>
			</td>
			</TR>
		</TABLE>
	 <a href="list">전체화면</a>
		<br><br>

	</div>
</body>
</html>






