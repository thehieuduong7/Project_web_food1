<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>    

<!-- header section starts      -->
<header class="fixed-top" >
    <a href="<c:url value="/waiting"/>" class="logo"><i class="fas fa-utensils"></i>food</a>
    <nav class="navbar">
        
    </nav>

    <div class="icons">
        <i class="fas fa-bars" id="menu-bars"></i>
        <a href="<c:url value="/waiting"/>" class="fas fa-home"></a>
        <a href="<c:url value="/web/product"/>" class="fas fa-stream"></a>        
        <a href="cart" class="wrap-icon-cart cart-basket fas fa fa-shopping-cart fa-lg">
            <span class="d-flex align-items-center justify-content-center">
               
            </span>
        </a>
       	<a href="<c:url value="/web/StatisticsForUserController"/>" class="fas fa-chart-line"></a>
        
	     <a href="<c:url value="/logout"/>" class="fas fa-user-times"></a>

		

	</div>


    
</header>
<!-- header section ends-->