<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 03/30/2023
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
</head>
<body>
<form action="" method="post" id="my-form" class="container">
    <div class="row">

        <div class="form-group row">
            <input class="form-control" type="hidden" name="Id" value="${kh.id}">
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-sm-2 col-form-label">Ma</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="Ma" value="${kh.ma}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-sm-2 col-form-label">Ten</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="Ten" value="${kh.ten}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-sm-2 col-form-label">TenDem</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="TenDem" value="${kh.tenDem}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group">
                <label class="col-sm-2 col-form-label">Ho</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="Ho" value="${kh.ho}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group ">
                <label class="col-sm-2 col-form-label">NgaySinh</label>
                <div class="col-sm-10">
                    <input value="${ngaySinh}" class="form-control" type="date" name="ngaySinh"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group ">
                <label class="col-sm-2 col-form-label">DiaChi</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="DiaChi" value="${kh.diaChi}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group ">
                <label class="col-sm-2 col-form-label">Sdt</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="Sdt" value="${kh.sdt}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group ">
                <label class="col-sm-2 col-form-label">ThanhPho</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="ThanhPho" value="${kh.thanhPho}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group ">
                <label class="col-sm-2 col-form-label">QuocGia</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="QuocGia" value="${kh.quocGia}"><br>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="form-group ">
                <label class="col-sm-2 col-form-label">MatKhau</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="MatKhau" value="${kh.matKhau}"><br>
                </div>
            </div>
        </div>
    </div>
    <center>
        <button class="btn btn-success" type="submit" name="submit" value="update"
                onclick="changeAction('/User/update')">Update
        </button>
    </center>
</form>
<script src="/js/changAction.js"></script>

</body>
</html>
