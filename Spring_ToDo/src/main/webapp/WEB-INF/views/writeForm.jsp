<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2022-04-20
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/writeP" method="post">
    <div class="form-group text-left">
        <label for="title">Todo:</label> <input type="text" class="form-control" name="content">
    </div>

    <div class="form-group text-left">
        <label for="pw">id:</label> <input type="pass" class="form-control" name="id">
    </div>
    <div class="form-group text-left">
        <label for="name">종료일</label> <input type="date" class="form-control" name="edate">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
