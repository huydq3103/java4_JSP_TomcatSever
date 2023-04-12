<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 03/25/2023
  Time: 8:58 PM
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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
    <!-- MDB -->
    <link rel="stylesheet" href="/css/mdb.min.css" />
    <!-- Custom styles -->
    <link rel="stylesheet" href="/css/admin.css" />
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
<%@include file="../layout2/menuTop.jsp" %>
<%@include file="../layout2/menu.jsp" %>
<main style="margin-top: 58px">
    <div class="container-fluid pt-4">
        <!-- Section: Main chart -->
        <section class="mb-4">

            <div class="card-header py-3">
                <h5 class="mb-0 text-center"><strong>Product</strong></h5>
            </div>

            <div class="container overflow-hidden text-center">
                <div class="row gy-5">
                    <div class="col-lg-12">

                        <form action="" method="post" id="my-form" class="container" style="margin-top: 30px;">
                            <div class="form-group row">
                                <input class="form-control" type="hidden" name="Id" value="${ctsp.sanpham.idSP}">
                                <input class="form-control" type="hidden" name="IdCTSP" value="${ctsp.idCTSP}">
                            </div>
                            <div class="col-sm-10">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Ma</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" type="text" name="Ma" value="${ctsp.sanpham.ma}"><br>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Ten</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" type="text" name="Ten" value="${ctsp.sanpham.ten}"><br>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Nam BH</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" type="text" name="nambh" value="${ctsp.namBH}"><br>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Mo ta</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" type="text" name="mota" value="${ctsp.moTa}"><br>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">So luong ton</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" type="text" name="soluongton" value="${ctsp.soLuongTon}"><br>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Gia nhap</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" type="text" name="gianhap" value="${ctsp.giaNhap}"><br>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10">
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">Gia ban</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" type="text" name="giaban" value="${ctsp.giaBan}"><br>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10" style="margin-left: -358px;">
                                <label class="col-sm-2 col-form-label">Nha san xuat</label>
                                <select name="nsx" >
                                    <c:forEach items="${nsxArrayList}" var="nsx">
                                        <option value="${nsx.ma}" <c:if test="${ctsp.nsx.ten==nsx.ten}">selected</c:if> >${nsx.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-sm-10" style="margin-left: -325px;">
                                <label class="col-sm-2 col-form-label">Mau sac</label>
                                <select name="mausac">
                                    <c:forEach items="${mausacArrayList}" var="mausac">
                                        <option value="${mausac.ma}" <c:if test="${ctsp.mausac.ten==mausac.ten}">selected</c:if> >${mausac.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-sm-10" style="margin-left: -326px;">
                                <label class="col-sm-2 col-form-label">Dong san pham</label>
                                <select name="dongsp">
                                    <c:forEach items="${dongspArrayList}" var="dongsp">
                                        <option value="${dongsp.ma}" <c:if test="${ctsp.dongsp.ten==dongsp.ten}">selected</c:if> >${dongsp.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <button style="margin-top: 30px;" type="submit" class="btn btn-primary" name="submit" value="add" onclick="changeAction('/SanPham/add')">Add</button>
                            <button  style="margin-top: 30px;" type="submit" class="btn btn-primary" name="submit" value="update" onclick="changeAction('/SanPham/update')">Update</button>
                        </form>
                        <br>

                    </div>
                </div>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th >Ma SP</th>
                    <th >Ten SP</th>
                    <th >Nam BH</th>
                    <th >Mo ta</th>
                    <th >So luong ton</th>
                    <th >Gia nhap</th>
                    <th >Gia ban</th>
                    <th >Nha san xuat</th>
                    <th >Mau sac</th>
                    <th >Dong san pham</th>
                    <th >Chuc nang</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${chitietsanphamArrayList}" var="sp">
                    <tr>

                        <th >${sp.sanpham.ma}</th>
                        <th >${sp.sanpham.ten}</th>
                        <th >${sp.namBH}</th>
                        <th >${sp.moTa}</th>
                        <th >${sp.soLuongTon}</th>
                        <th >${sp.giaNhap}</th>
                        <th >${sp.giaBan}</th>
                        <th >${sp.nsx.ten}</th>
                        <th >${sp.mausac.ten}</th>
                        <th >${sp.dongsp.ten}</th>
                        <th>
                            <a href="/SanPham/details?id=${sp.id}">Details</a>
                            <a href="/SanPham/delete?id=${sp.sanpham.ma}">Delete</a></th>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
    </section>
    <!-- Section: Main chart -->

    </div>
</main>
<script src="../js/changAction.js"></script>
</body>
</html>
