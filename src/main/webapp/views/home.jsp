<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!-- search form  -->
<form action="" id="search-form">
    <input type="search" placeholder="search here..." name="" id="search-box">
    <label for="search-box" class="fas fa-search"></label>
    <i class="fas fa-times" id="close"></i>
</form>

<!-- home section starts  -->

<section class="home" id="home">
    <div class="home-slider">
        <div class=" wrapper">
            <div class="slide">
                <div class="content">
                    <span>Thực đơn đặc biệt</span>
                    <h3>Cơm tấm</h3>
                    <p>
                        Cơm tấm,một món ăn được chế biến từ các nguyên liệu rất đơn giản nhưng làm nên hương vị rất riêng,
                        khó lẫn với bất kỳ món cơm nào khác.
                    </p>
                </div>
                <div class="image">
                    <img src="/assets/img/home-11.png" alt="">
                </div>
            </div>
        </div>
        <div class="swiper-pagination"></div>
    </div>
</section>
<!-- home section ends -->

<!-- dishes section starts  -->

<section class="dishes" id="dishes">

    <h3 class="sub-heading"> Our dishes </h3>
    <h1 class="heading"> popular dishes </h1>

    <div class="box-container">

        <div class="box">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-eye"></a>
            <img src="/assets/img/caKhoTo.jpg" alt="">
            <h3>Cá kho tộ</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
            <span>$15.99</span>
            <a href="#" class="btn">
                <i class="fas fa-shopping-basket"></i>
                Thêm vào giỏ</a>
        </div>

        <div class="box">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-eye"></a>
            <img src="/assets/img/khoQuet.jpg" alt="">
            <h3>Kho quẹt</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
            <span>$15.99</span>
            <a href="#" class="btn">
                <i class="fas fa-shopping-basket"></i>
                Thêm vào giỏ</a>
        </div>

        <div class="box">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-eye"></a>
            <img src="/assets/img/banhMi.jpg" alt="">
            <h3>Bánh mỳ</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
            <span>$15.99</span>
            <a href="#" class="btn">
                <i class="fas fa-shopping-basket"></i>
                Thêm vào giỏ</a>
        </div>

        <div class="box">
            <a href="#" class="fas fa-heart"></a>
            <a href="#" class="fas fa-eye"></a>
            <img src="/assets/img/goiGa.jpeg" alt="">
            <h3>Gỏi gà</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
            <span>$15.99</span>
            <a href="#" class="btn">
                <i class="fas fa-shopping-basket"></i>
                Thêm vào giỏ</a>
        </div>

    </div>

</section>

<!-- dishes section ends -->

<!-- about section starts  -->
<section class="about" id="about">
    <h3 class="sub-heading"> why choose us </h3>
    <h1 class="heading"> Mua hàng nhanh chóng và đơn giản </h1>

    <div class="row">

        <div class="image">
            <img src="/assets/img/about-img.png" alt="">
        </div>

        <div class="content">
            <h3>Món ngon đa dạng</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolore, sequi corrupti corporis quaerat voluptatem ipsam neque labore modi autem, saepe numquam quod reprehenderit rem? Tempora aut soluta odio corporis nihil!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam, nemo. Sit porro illo eos cumque deleniti iste alias, eum natus.</p>
            <div class="icons-container">
                <div class="icons">
                    <i class="fas fa-shipping-fast"></i>
                    <span>Giao hàng miễn phí</span>
                </div>
                <div class="icons">
                    <i class="fas fa-dollar-sign"></i>
                    <span>Thanh toán nhanh gọn</span>
                </div>
                <div class="icons">
                    <i class="fas fa-headset"></i>
                    <span>CSKH 24/7 </span>
                </div>
            </div>
            
        </div>

    </div>
</section>
<!-- about section ends -->






