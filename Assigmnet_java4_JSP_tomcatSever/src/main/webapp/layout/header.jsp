<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="/trang-chu">Vegefoods</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="/trang-chu" class="nav-link">Home</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">Shop</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="shop.html">Shop</a>
                        <a class="dropdown-item" href="wishlist.html">Wishlist</a>
                        <a class="dropdown-item" href="product-single.html">Single Product</a>
                        <a class="dropdown-item" href="/GioHang/hien-thi">Cart</a>
                        <a class="dropdown-item" href="checkout.html">Checkout</a>
                    </div>
                </li>
                <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
                <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
                <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>

<c:if test="${sessionScope.isLoggedIn != true}">
                <li class="nav-item"><a href="/Login/hien-thi" class="nav-link"><i class="fa fa-user fa-1x"
                                                                                   aria-hidden="true"
                                                                                   style="margin-top: 5px;"></i></a>
                </li>
</c:if>
            <!--dieu kien-->
             <c:if test="${sessionScope.isLoggedIn}">
                 <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#"  data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">${sessionScope.user}</a>
                     <div class="dropdown-menu" aria-labelledby="dropdown04">
                         <a class="dropdown-item" href="/User/details?id=${sessionScope.user}">Profile</a>
                         <a class="dropdown-item" href="/logout">Logout</a>
                     </div>
                 </li>

             </c:if>


                <li class="nav-item cta cta-colored"><a href="cart.html" class="nav-link"><span
                        class="icon-shopping_cart"></span>[${sessionScope.dem}]</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->