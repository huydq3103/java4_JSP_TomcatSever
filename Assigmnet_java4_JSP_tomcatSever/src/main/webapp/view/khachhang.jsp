<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 3/22/2023
  Time: 1:06 PM
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
          <p style="margin-top: 10px;margin-bottom: 20px;text-align: center">Form dang ky</p>
<form action="" method="post" id="my-form"  class="container">
  <div class="row">

         <div class="form-group row" >
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
    <button class="btn btn-success "  style="margin-top: 20px;width: 200px" type="submit" name="submit" value="add"
            onclick="changeAction('/User/add')">
        Dang ky</button>

</center>
<%--    <button class="btn btn-success"  type="submit" name="submit" value="update" onclick="changeAction('/User/update')">Update</button>--%>
</form>
<br>
<%--<table class="table">--%>
<%--    <thead>--%>
<%--    <tr>--%>

<%--        <th scope="col">Ma</th>--%>
<%--        <th scope="col">Ten</th>--%>
<%--        <th scope="col">Ten dem</th>--%>
<%--        <th scope="col">Ho</th>--%>
<%--        <th scope="col">Ngay sinh</th>--%>
<%--        <th scope="col">Dia Chi</th>--%>
<%--        <th scope="col">Sdt</th>--%>
<%--        <th scope="col">THanh pho</th>--%>
<%--        <th scope="col">Quoc gia</th>--%>
<%--        <th scope="col">Mat khau</th>--%>
<%--        <th scope="col">Chức năng</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach items="${khachhangArrayList}" var="khachhang">--%>
<%--        <tr>--%>

<%--            <th scope="row">${khachhang.ma}</th>--%>
<%--            <th scope="row">${khachhang.ten}</th>--%>
<%--            <th scope="row">${khachhang.tenDem}</th>--%>
<%--            <th scope="row">${khachhang.ho}</th>--%>
<%--            <th scope="row">${khachhang.ngaySinh}</th>--%>
<%--            <th scope="row">${khachhang.diaChi}</th>--%>
<%--            <th scope="row">${khachhang.sdt}</th>--%>
<%--            <th scope="row">${khachhang.thanhPho}</th>--%>
<%--            <th scope="row">${khachhang.quocGia}</th>--%>
<%--            <th scope="row">${khachhang.matKhau}</th>--%>
<%--            <th scope="row"><a href="/User/details?id=${khachhang.id}">Details</a></th>--%>
<%--            <th scope="row"><a href="/User/delete?id=${khachhang.id}">Delete</a></th>--%>

<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
<script>
    function changeAction(newAction) {
        document.getElementById("my-form").action = newAction;
    }


</script>
</body>
</html>
