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

		<c:forEach items="${ListTop4 }" var="pro">
		
        <div class="box">
            <a href="<c:url value="/web/productDetail?pid=${pro.getId_product() }" />" class="fas fa-eye"></a>
            <img src="<c:url value="${pro.getPhoto()}"/>" width= "100px" height="100px">
            <h3>${pro.getName_food() }</h3>
            <div class="stars">
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star"></i>
                <i class="fas fa-star-half-alt"></i>
            </div>
            <div style="height:70px">
            <span  style="text-decoration-line:${(pro.getSalePercent()==0)?"none;":"line-through"}"> ${pro.getPrice()}đồng </span>
            
           <span style="display:${(pro.getSalePercent()==0)?"None":"Block"};" > ${pro.getBuyPrice()}đồng  </span>
            
            
            </div>
            
            <button class="btn" onclick="plusCart(${pro.getId_product()})">
                <i class="fas fa-shopping-basket"></i>
                Thêm vào giỏ</button>
        </div>
        
		</c:forEach>
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
var urlCartAPI = '<c:url value="/CartAPI" />'

	function plusCart(id_product){
			var data={
					id_product: id_product,
					amount: 1
			}
			$.ajax({
				  url: urlCartAPI,
				  type: 'post',
				  data: JSON.stringify(data),
				  success: function (data, status) {
					 console.log('done');
					 if(data=='true'){
						alert('Thêm vào giỏ hàng thành công')
					 }
					 else {
						 alert("loi");
					 }
				  },
				  error: function (xhr, desc, err) {
				    console.log(xhr);
				    console.log("Desc: " + desc + "\nErr:" + err);
				  },
				  async: false
				});
		}

</script>





