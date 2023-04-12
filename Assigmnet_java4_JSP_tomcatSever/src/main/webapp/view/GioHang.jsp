<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 03/31/2023
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gio hang</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="../css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="../css/animate.css">

    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">

    <link rel="stylesheet" href="../css/aos.css">

    <link rel="stylesheet" href="../fonts/ionicons/css/ionicons.min.css">

    <link rel="stylesheet" href="../css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="../css/jquery.timepicker.css">


    <link rel="stylesheet" href="../css/flaticon.css">
    <link rel="stylesheet" href="../css/icomoon.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .table-dark-green {
            background-color: darkgreen;
            color: white;
        }

        .no-border th {
            border: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.js"
            integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body class="goto-here">

<%@include file="../layout/header.jsp" %>

<div class="hero-wrap hero-bread" style="background-image: url('/images/bg_1.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Cart</span></p>
                <h1 class="mb-0 bread">My Cart</h1>
            </div>
        </div>
    </div>
</div>
<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <table class="table no-border">
                <thead class="table-dark-green">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Ten san pham</th>
                    <th scope="col">So luong</th>
                    <th scope="col">Don gia</th>
                    <th scope="col">Thanh tien</th>
                    <th>Action</th>

                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="0"/>
                <c:set var="count" value="0"/>

                <c:forEach items="${giohangchitietArrayList}" var="gh">
                    <c:set var="total" value="${total + (gh.soLuong * gh.chitietsanpham.giaBan)}"/>
                    <c:set var="count" value="${count+1}"/>
                    <tr>
                        <th>${count}</th>
                        <th>${gh.chitietsanpham.sanpham.ten}</th>
                        <td>${gh.soLuong}</td>
                        <td>${gh.chitietsanpham.giaBan}</td>
                        <td>${gh.soLuong * gh.chitietsanpham.giaBan}</td>
                            <%--                        <td><button  onclick="delte('${gh.chitietsanpham.id}')" style="width: 200px">X</button></td>--%>
                            <%--                        <td><  class="fa-solid fa-x" onclick="delte('${gh.chitietsanpham.id}')"></td>--%>
                        <td><i class="fa fa-close" onclick="delte('${gh.chitietsanpham.id}')"></i></td>
                    </tr>
                </c:forEach>
                </tbody>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th>Tổng tiền</th>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th>${total}</th>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th>
                        <button onclick="showConfirm()" id="myButton" class="btn btn-primary" style="width: 200px">Thanh
                            toán
                        </button>
                    </th>

                    <%--                    <c:if test="{total<0" >--%>
                    <%--                        <th>--%>
                    <%--                            <button href="/trang-chu" class="btn btn-primary " style="width: 200px">Back to home</button>--%>
                    <%--                        </th>--%>
                    <%--                    </c:if>--%>
                </tr>

            </table>
        </div>
    </div>
</section>
<%@include file="../layout/footer.jsp" %>
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery-migrate-3.0.1.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.easing.1.3.js"></script>
<script src="/js/jquery.waypoints.min.js"></script>
<script src="/js/jquery.stellar.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/jquery.magnific-popup.min.js"></script>
<script src="/js/aos.js"></script>
<script src="/js/jquery.animateNumber.min.js"></script>
<script src="/js/bootstrap-datepicker.js"></script>
<script src="/js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="/js/google-map.js"></script>
<script src="/js/main.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    function delte(id) {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Bạn có chắc không?',
            text: "Bạn sẽ không thể hoàn tác điều này!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Có, xóa nó!',
            cancelButtonText: 'Không, hủy!',
            reverseButtons: true
        }).then((result) => {

            if (result.isConfirmed) {
                $.ajax({
                    url: "/GioHang/remove",
                    method: "GET",
                    data: {id: id}
                }).done(function (data) {
                    // Thực hiện hành động cần thiết với dữ liệu trả về (mảng)
                    swalWithBootstrapButtons.fire(
                        'Đã xóa!',
                        'Tập tin của bạn đã bị xóa.',
                        'success'
                    )
                    window.location.href = "/GioHang/hien-thi";
                }).fail(function () {
                    swalWithBootstrapButtons.fire(
                        'Lỗi!',
                        'Đã xảy ra lỗi khi thực hiện xóa.',
                        'error'
                    )
                });

            } else if (
                /* Xem thêm về xử lý tắt ở dưới */
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    'Đã hủy bỏ',
                    'Sanr phẩm  của bạn đã an toàn :)',
                    'error'
                )
            }
        })
    }


    function showConfirm() {
        if (confirm("Are you sure you want to pay?")) {
            var amount = prompt("Enter the amount to pay:");
            if (${total} == Number.parseFloat(amount)
        )
            {
                alert("Payment successful");
                $.ajax({
                    url: "/GioHang/delete",
                    data: {amount: amount}
                }).done(function (data) {
                    //Do what you need with data (your array) here
                });

                window.location.href = "/GioHang/hien-thi";
            }
        else
            {
                alert("Payment Unsuccessful")
            }

        }

    }
</script>
</body>
</html>
