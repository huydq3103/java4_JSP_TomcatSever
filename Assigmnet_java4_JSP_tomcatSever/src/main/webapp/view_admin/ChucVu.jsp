<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 3/24/2023
  Time: 12:31 PM
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
    <div class="container pt-4">
        <!-- Section: Main chart -->
        <section class="mb-4">
            <div class="card">
                <div class="card-header py-3">
                    <h5 class="mb-0 text-center"><strong>Sales</strong></h5>
                </div>

                <div class="container overflow-hidden text-center">
                    <div class="row gy-5">
                        <div class="col-lg-12">
                            <form action="" method="post" id="my-form"  style="margin-top: 60px; ">
                                <div class="form-group row">
                                    <input class="form-control" type="hidden" name="Id" value="${cv.id}">
                                </div>
                                <div class="col-sm-10">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Ma</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" type="text" name="Ma" value="${cv.ma}"><br>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-10">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Ten</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" type="text" name="Ten" value="${cv.ten}"><br>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary" name="submit" value="add" onclick="changeAction('/ChucVu/add')">Add</button>
                                <button type="submit"class="btn btn-primary" name="submit" value="update" onclick="changeAction('/ChucVu/update')">Update</button>
                            </form>
                            <br>
                            <table class="table " >
                                <thead>
                                <tr>
                                    <th scope="col">Ma</th>
                                    <th scope="col">Ten</th>
                                    <th scope="col">Chuc nang</th>

                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${chucvuArrayList}" var="chucvu">
                                    <tr>

                                        <th scope="row">${chucvu.ma}</th>
                                        <th scope="row">${chucvu.ten}</th>
                                        <th scope="row"><a href="/ChucVu/details?id=${chucvu.id}">Details</a>
                                            <a href="/ChucVu/delete?id=${chucvu.id}">Delete</a></th>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>

            </div>
        </section>
        <!-- Section: Main chart -->

    </div>
</main>
<script>
    function changeAction(newAction) {
        document.getElementById("my-form").action = newAction;
    }
</script>
</body>
</html>
