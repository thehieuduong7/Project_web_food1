<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>    

<!-- header section starts      -->
<header class="fixed-top">
    <a href="<c:url value="/waiting"/>" class="logo"><i class="fas fa-utensils"></i>food</a>
    <nav class="navbar">
    </nav>

    <div class="icons">
           <a href="<c:url value="/seller/products"/>" class="fas fa-stream"></a>        
    
          <a href="<c:url value="/seller/StatisticsController"/>" class="fas fa-chart-line"></a>
        
	     <a href="<c:url value="/logout"/>" class="fas fa-user-times"></a>
    </div>

    
</header>
<!-- header section ends-->