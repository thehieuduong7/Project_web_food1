<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>    

<!-- header section starts      -->
<header class="fixed-top">
    <a href="#" class="logo"><i class="fas fa-utensils"></i>food</a>
    <nav class="navbar">
        <a class="active" href="<c:url value="/web/home"/>">Trang chủ</a>
        <a href="<c:url value="/web/product"/>">Thực đơn</a>
    </nav>

    <div class="icons">
        <i class="fas fa-bars" id="menu-bars"></i>
        <i class="fas fa-search" id="search-icon"></i>
        <a href="cart" class="wrap-icon-cart cart-basket fas fa fa-shopping-cart fa-lg">
            <span class="d-flex align-items-center justify-content-center">
                ${cart.countItem}
            </span>
        </a>
        <a href="Login2Servlet?action=checkUser" class="fas fa-user"></a>
    </div>

    
</header>
<!-- header section ends-->