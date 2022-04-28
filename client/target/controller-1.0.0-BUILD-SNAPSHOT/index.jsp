<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>RESTful 웹서비스 클라이언트(JSON)</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        function customerListResult(data) {
            $.each(data, function (index, item) {
                $('<tr>').append($('<td>').text(item.name)).append($('<td>').text(item.age)).append($('<td>').appendTo('tbody'));
            })
        }

        function customerList() {
            $('tbody').empty();
            $.ajax({
                url: "http://localhost:8080/",
                type: 'get',
                dataType: "json",
                success: function (data) {
                    customerListResult(data);
                },
                error: function (xhr, status, msg) {
                    alert("error :" + status);
                }
            })
        }

        $(document).ready(function () {
            customerList();
        })
    </script>
</head>
<body>
<div class="container">
    <h2>사용자 목록</h2>
    <table class="table text-center">
        <tbody></tbody>
    </table>
</div>
</body>
</html>





