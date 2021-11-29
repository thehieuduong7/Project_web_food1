<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Food Web</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Varela+Round&display=swap');
    </style>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- custom css file link  -->
    <!-- <link rel="stylesheet" href="/assets/css/style.css">  -->
    <!-- Roboto Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
    <!-- Font Awesome -->
    <!-- <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css"> -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Material Design Bootstrap -->
    <!-- <link rel="stylesheet" href="/assets/css/mdb-pro.min.css"> -->
    <!-- Material Design Bootstrap Ecommerce -->
    <link rel="stylesheet" href="/assets/css/mdb.ecommerce.min.css">
    
    <link type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="/assets/css/templatemo.css">
    <!-- Load fonts style after rendering the layout styles -->
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <!-- Slick -->
    <link rel="stylesheet" type="text/css" href="/assets/css/slick.min.css">
    <link rel="stylesheet" type="text/css" href="/assets/css/slick-theme.css">
    <link rel="stylesheet" type="text/css" href="/assets/css/styleDetailFood.css">
    <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet" type="text/css">
    <style>
    .wrap-icon-cart{
        display: inline-block;
    }
    .cart-basket{
        width: 45px !important;
        font-size: .6rem;
        /*position: absolute;*/
        top: -6px;
        right: -5px;
        width: 15px;
        height: 15px;
        color: #fff;
        background-color: #418deb;
        border-radius: 50%;
    }
</style>
</head>
<body>

<!-- header -->
<%@ include file="/common/web/header.jsp" %>
<!-- end header -->

<!-- content -->

<dec:body />
	
<!-- end content -->

<!-- footer -->
<%@ include file="/common/web/footer.jsp" %>
<!--end footer -->

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="assets/js/script.js"></script>



<!-- JS -->

<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
    