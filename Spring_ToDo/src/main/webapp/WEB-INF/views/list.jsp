<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2022-04-20
  Time: 오후 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/search" method="get">
        <select name="condition" >
            <option value="id">id</option>
            <option value="num">num</option>
        </select>
        <input type="text" name="word">
        <button type="submit" class="btn btn-primary">검색</button>
    </form>
</div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>번호</th>
        <th>Todo</th>
        <th>작성자</th>
        <th>시작날짜</th>
        <th>끝 날짜</th>
        <th>종료</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list }" var="row">
        <tr>
            <td>${row.num }</td>
            <td><a href="/read?num=${row.num}">${row.content }</a></td>
            <td>${row.id }</td>
            <td>${row.sdate }</td>
            <td>${row.edate }</td>
            <td>${row.done }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/write">새글쓰기</a>
<a href="/deleteAll">전체 삭제</a>
<a href="/">홈으로</a>
<br><br>
</div>
</body>
</html>
