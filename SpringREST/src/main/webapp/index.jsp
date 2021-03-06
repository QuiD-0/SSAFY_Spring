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

        function customerSelectResult(result) {
            $('#num').val(result.num);
            $('#name').val(result.name);
            $('#address').val(result.address);
        }

        function customerSelect(result) {
            $('tbody').on('click', 'tr', function () {
                let num = $(this).find('#hnum').val();
                $.ajax({
                    url: "http://localhost:8000/customers/" + num,
                    type: "get",
                    dataType: "json",
                    success: customerSelectResult,
                })
            })
        }


        function customerListResult(data) {
            $.each(data, function (index, item) {
                $('<tr>').append($('<td>').text(item.num)).append($('<td>').text(item.name)).append($('<td>').text(item.address)).append($('<input type="hidden" id="hnum">').val(item.num)).appendTo('tbody');
            })
        }

        function customerList() {
            $('tbody').empty();
            $.ajax({
                url: "http://localhost:8000/customers",
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

        function clear() {
            $('#num').val("");
            $('#name').val("");
            $('#address').val("");
        }

        function customerInsert() {
            $('#btnInsert').on('click', function () {
                //    입력값 받아오기
                //    ajax 요청
                let num = $('#num').val();
                let name = $('#name').val();
                let address = $('#address').val();
                if (num != "" && name != "" && address != "") {
                    $.ajax({
                        url: "http://localhost:8000/customers",
                        type: "post",
                        contentType: "application/json",
                        data: JSON.stringify({"num": num, "name": name, "address": address}),
                        success: function () {
                            customerList();
                            clear();
                        }
                    })
                } else {
                    alert("값을 입력해 주세요")
                }
            });
        }

        function customerUpdate() {
            $('#btnUpdate').on('click', function () {
                //    입력값 받아오기
                //    ajax 요청
                let num = $('#num').val();
                let name = $('#name').val();
                let address = $('#address').val();
                if (num != "" && name != "" && address != "") {
                    $.ajax({
                        url: "http://localhost:8000/customers",
                        type: "put",
                        contentType: "application/json",
                        data: JSON.stringify({"num": num, "name": name, "address": address}),
                        success: function () {
                            customerList();
                            clear();
                        }
                    })
                } else {
                    alert("값을 입력해 주세요")
                }
            });
        }

        function customerDelete() {
            $('#btnDelete').on('click', function () {
                //    입력값 받아오기
                //    ajax 요청
                let num = $('#num').val();
                if (num != "") {
                    $.ajax({
                        url: "http://localhost:8000/customers/" + num,
                        type: "delete",
                        success: function () {
                            customerList();
                            clear();
                        }
                    })
                } else {
                    alert("값을 입력해 주세요")
                }
            });
        }

        function init() {
            $('#btnInit').on('click', function () {
                clear();
            });
        }

        function customerSearch() {
            $('#btnSearch').on('click', function () {
                let address = $('#address').val();
                if (address != "") {
                    $('tbody').empty();
                    $.ajax({
                        url: "http://localhost:8000/customers/addr/" + address,
                        type: "get",
                        success: function (data) {
                            customerListResult(data);
                        },
                    })
                } else {
                    alert("값을 입력해 주세요")
                }
            });
        }

        function customerAll() {
            $('#btnAll').on('click', function () {
                customerList();
            });
        }

        $(document).ready(function () {
            customerList();
            customerInsert();
            customerSelect();
            customerDelete();
            customerUpdate();
            customerSearch();
            customerAll();
            init();
        })
    </script>
</head>
<body>
<div class="container">
    <form id="form1" class="form-horizontal">
        <h2>Customer Management</h2>
        <div class="form-group">
            <label>번호:</label> <input type="text" class="form-control" id="num">
        </div>
        <div class="form-group">
            <label>이름:</label> <input type="text" class="form-control" id="name">
        </div>

        <div class="form-group">
            <label>주소:</label> <input type="text" class="form-control"
                                      id="address">
        </div>

        <div class="btn-group">
            <input type="button" class="btn btn-primary" value="등록" id="btnInsert"/>
            <input type="button" class="btn btn-primary" value="수정" id="btnUpdate"/>
            <input type="button" class="btn btn-primary" value="삭제" id="btnDelete"/>
            <input type="button" class="btn btn-primary" value="검색" id="btnSearch"/>
            <input type="button" class="btn btn-primary" value="모두보기" id="btnAll"/>
            <input type="button" class="btn btn-primary" value="초기화" id="btnInit"/>
        </div>
    </form>
</div>
<hr/>
<div class="container">
    <h2>사용자 목록</h2>
    <table class="table text-center">
        <thead>
        <tr>
            <th class="text-center">번호</th>
            <th class="text-center">이름</th>
            <th class="text-center">주소</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
</body>
</html>





