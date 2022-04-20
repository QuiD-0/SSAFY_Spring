<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table class="table table-bordered">
    <TR>
        <TH>NUM</TH>
        <TD>${b.num }</TD>
        <Th>ID</TH>
        <TD>${b.id }</TD>
    </TR>
    <TR>
        <TH>SDATE</TH>
        <TD>${b.sdate }</TD>
        <TH>EDATE</TH>
        <TD>${b.edate }</TD>
    </TR>
    <TR>
        <TH>DONE</TH>
        <TD COLSPAN=3>${b.done }</TD>
    </TR>
    <TR>
        <TH>CONTENT</TH>
        <TD COLSPAN=3>
            <textarea readonly class="form-control" rows="5" id="comment" name="comment">${b.content }</textarea>
        </td>
    </TR>
</TABLE>
<a href="list">Todo 보기</a>
<a href="/delete?num=${b.num}">삭제하기</a>
<a href="/done?num=${b.num}">완료</a>
</body>
</html>
