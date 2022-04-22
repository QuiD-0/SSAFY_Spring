<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		<img src="/resources/image/f3.jpg" class="rounded-circle"/>
		<h1>Login</h1>
		<form method="post" action="loginProcess">
			<div class="form-group text-left">
				<label for="id">ID:</label>
				<input type="text" class="form-control"	name="id">
			</div>
			<div class="form-group  text-left">
				<label for="pass">Password:</label> 
				<input type="password" class="form-control" name="pw">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>