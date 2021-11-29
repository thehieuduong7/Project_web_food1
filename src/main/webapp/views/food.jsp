<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>

<!-- menu section starts  -->
<section style="text-align: center" class="menu" id="menu">
	<h1>a</h1>a<h1>a</h1>
    <h3 class="sub-heading"> My menu </h3>

    <h1 class="heading"> today's speciality </h1>

    <section class="catalog">
        <div class="food-type">
            <input name="inputFlagCate" id="inputFlagCate" type="hidden" value="0">
            <button onclick="loadCategory(0);changeCateId(0)" class="btn-cate btn btn-primary">Tất cả</button>
            <button onclick="loadCategory(1); changeCateId(1)" class="btn-cate btn btn-primary">Đồ ăn nhanh</button>
            <button onclick="loadCategory(2); changeCateId(2)" class="btn-cate btn btn-primary">Đồ uống</button>
            <button onclick="loadCategory(3); changeCateId(3)" class="btn-cate btn btn-primary">Ăn vặt</button>
            <button onclick="loadCategory(4); changeCateId(4)" class="btn-cate btn btn-primary">Tráng miệng</button>
        </div>
    </section>

    <div id="content" class="box-container">
        <c:forEach var="item" items="${listFood}">
            <form action="DetailFoodServlet" method="post">
                <input type="hidden" name="foodId" value="<c:out value='${item.fid}'/>">
                <a style="text-decoration: none; color: black;" onclick="this.parentNode.submit()">
                    <div class="box count-food">
                        <div class="image">
                            <img src="${item.galleries[0].img_url}" alt="">
                        </div>
                        <div class="content">
                            <div class="stars">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star-half-alt"></i>
                            </div>
                            <h3><c:out value="${item.f_name}"/></h3>
                            <p><c:out value="${item.desciprtion}"/></p>

                                <%--                    <form action="DetailFoodServlet" method="post">--%>
                                <%--                        <input type="text" name="foodId" value="<c:out value='${item.fid}'/>">--%>
                                <%--                        <input class="btn" type="submit" value="Xem hàng tí nào">--%>
                                <%--                    </form>--%>

                            <span class="price"><c:out value="${item.priceCurrencyFormat}"/></span>

                        </div>
                    </div>
                </a>
            </form>
        </c:forEach>
    </div>
    <button style="margin-top: 50px; padding: 10px 40px;" onclick="loadMore()" class="btn btn-primary">Load more</button>
</section>
<!-- menu section ends -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function loadMore(){
        var flagCate = document.getElementById("inputFlagCate").value;
        var amount = document.getElementsByClassName("count-food").length;
        $.ajax({
            url: "/LoadMoreServlet",
            type: "get", //send it through get method
            data: {
                inputFlagCate: flagCate,
                exist: amount,
            },
            success: function(data) {
                var row = document.getElementById("content");
                row.innerHTML += data;
            },
            error: function(xhr) {

            }
        });
    }

    function loadCategory(cateId){
        // var length = document.getElementsByClassName("count-food").length;
        $.ajax({
            url: "/LoadCategoryServlet",
            type: "get", //send it through get method
            data: {
                cateId: cateId,
            },
            success: function(data) {
                var row = document.getElementById("content");
                row.innerHTML = data;
            },
            error: function(xhr) {

            }
        });
    }

    function changeCateId(cateId){
        document.getElementById("inputFlagCate").value = cateId;
    }
</script>

</body>
</html>