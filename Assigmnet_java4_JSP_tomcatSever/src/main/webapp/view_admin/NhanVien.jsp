<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 03/27/2023
  Time: 12:51 PM
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"/>
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"/>
    <!-- MDB -->
    <link rel="stylesheet" href="/css/mdb.min.css"/>
    <!-- Custom styles -->
    <link rel="stylesheet" href="/css/admin.css"/>
    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
            rel="stylesheet"
    />
</head>
<body>
<form action="" method="post" id="my-form"  style="margin-top: 30px">
    <div class="container">
        <div class="row mx-auto">
            <div class="form-group row">
                <input class="form-control" type="hidden" name="Id" value="${nv.id}">
            </div>
            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Ma</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="Ma" value="${nv.ma}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Ten</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="Ten" value="${nv.ten}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">TenDem</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="TenDem" value="${nv.tenDem}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Ho</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="Ho" value="${nv.ho}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <label class="col-sm-2 col-form-label">Gioi tinh</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="GioiTinh"
                           <c:if test="${nv.gioiTinh == nam}">selected</c:if> value="nam">
                    <label class="form-check-label">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="GioiTinh" value="nu"
                           <c:if test="${nv.gioiTinh == nu}">selected</c:if> >

                    <label class="form-check-label">NU</label>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">NgaySinh</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="date" name="NgaySinh" value="${ngaySinh}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">DiaChi</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="DiaChi" value="${nv.diaChi}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Sdt</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="Sdt" value="${nv.sdt}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">MatKhau</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="text" name="MatKhau" value="${nv.matKhau}"><br>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <label class="col-sm-2 col-form-label" >Chuc vu</label>
                <select name="chucvu">
                    <c:forEach items="${chucvuArrayList}" var="chucvu">
                        <option value="${chucvu.ma}"
                                <c:if test="${nv.chucvu.ten==chucvu.ten}">selected</c:if> >${chucvu.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-6">
                <label class="col-sm-2 col-form-label">Cua hang</label>
                <select name="cuahang">
                    <c:forEach items="${cuahangArrayList}" var="cuahang">
                        <option value="${cuahang.ma}"
                                <c:if test="${nv.cuahang.ten==cuahang.ten}">selected</c:if> >${cuahang.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-6">
                <label class="col-sm-2 col-form-label">Trang thai</label>
                <select name="trangthai">

                    <option value="1"
                            <c:if test="${nv.trangThai==1}">selected</c:if> >Dang Hoat dong
                    </option>
                    <option value="0"
                            <c:if test="${nv.trangThai==0}">selected</c:if> >Khong hoat dong
                    </option>
                </select>
            </div>


        </div>

    </div>
    <center style="margin-top: 40px;">
        <button class="btn btn-primary " type="submit" name="submit" value="add"
                onclick="changeAction('/NhanVien/add')">
            Add
        </button>
        <button class="btn btn-primary" type="submit" name="submit" value="update"
                onclick="changeAction('/NhanVien/update')">Update
        </button>
    </center>
</form>
<table class="table" >
    <thead>
    <tr>
        <th >Ma</th>
        <th >Ten</th>
        <th >Ten dem</th>
        <th >Ho</th>
        <th >Ngay sinh</th>
        <th>Gioi tinh</th>
        <th >Dia Chi</th>
        <th >Sdt</th>
        <th >Chuc vu</th>
        <th>Cua hang</th>
        <th >Trang Thai</th>
        <th >Mat khau</th>
        <th >Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nhanvienArrayList}" var="nhanvien">
        <tr>

            <th>${nhanvien.ma}</th>
            <th >${nhanvien.ten}</th>
            <th >${nhanvien.tenDem}</th>
            <th >${nhanvien.ho}</th>
            <th >${nhanvien.ngaySinh}</th>
            <th>${nhanvien.gioiTinh}</th>
            <th>${nhanvien.diaChi}</th>
            <th >${nhanvien.sdt}</th>
            <th >${nhanvien.chucvu.ma ==0 ? "nhan vien":"chu tich"}</th>
            <th>${nhanvien.cuahang.ten}</th>
            <th >${nhanvien.trangThai ==1 ? "dang hoat dong" : "khong hoat dong" }</th>
            <th >${nhanvien.matKhau}</th>
            <th><a href="/NhanVien/details?id=${nhanvien.id}">Details</a>
                <a href="/NhanVien/delete?id=${nhanvien.id}">Delete</a></th>

        </tr>
    </c:forEach>
    </tbody>
</table>


<script>
    function changeAction(newAction) {
        document.getElementById("my-form").action = newAction;
    }
</script>
</body>
</html>
