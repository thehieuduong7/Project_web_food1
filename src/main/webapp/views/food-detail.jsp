<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<div class="wrap pb-5"
	style="background-color: white; margin-top: 100px;">
	<div class="container">
		<div class="row" style="margin-top: 100px">


			<!-- col end -->
			<div class="col-8 col-md-8" style="">
				<div class="row" style="height:500px; ">
				            <img src="<c:url value="${product.getPhoto()}"/>" width= "70%" height="100%">
				
				</div>
				
				<div class="row">
					<h1 class mt-15>Bài viết đánh giá</h1>

					<div id="comment-container" style="max-height:300px;overflow: scroll;" >
						
					</div>
					<div id="comment-write" style="margin-top: 15px;">
						<div class="form-group">
							<label for="usr">Name:</label>
							<div class="row">
							
							 <input type="text" class="form-control" style="height:60px; font-size:14px;
							 	font-weight:700;
							 " id="comment-write-text"
							 placeholder="Comment about food!!!"
							 >
							<button type="button" id="comment-write-btn"
							class="btn btn-info input-group-append col-3" style="height:50px;">Comment</button>
						
							</div>
	
						
						</div>
					</div>>


				</div>
				
			</div>

			<div class="col-4 col-md-4">

				<div class="card new-border-card row">
					<div class="card-body">
						<h1 style="margin-top: 10px;" class="h2"
							style="font-size: 30px; font-weight: 500 !important;">${product.getName_food()}</h1>
						<p class="py-2">
							<i class="fa fa-star text-warning"></i> <i
								class="fa fa-star text-warning"></i> <i
								class="fa fa-star text-warning"></i> <i
								class="fa fa-star text-warning"></i> <i class="fa fa-star "></i>
							<span class="list-inline-item text-dark">Rating 4.8</span>
						</p>

						<p>
							<span class="mr-1"><strong
								style="font-size:18px; 
						 text-decoration-line: ${(product.getSalePercent()==0)?"none;":"line-through;"}">
									$${product.getPrice()}</strong></span> <span class="mr-1"><strong
								style="margin-left: 10px; font-size: 18px;">
									$${(product.getSalePercent()!=0)?product.getBuyPrice():""}</strong>
									</span>
						</p>

						<div class="wrap-description">
							<h4 class="">
								Category: <span>${cate }</span>
							</h4>
						</div>

						<div class="wrap-description" style="height: 165px;">
							<h4 class="">
								Description: <span>
								
								${product.getDescription()}</span>
							</h4>
						</div>

						<div class="col">
							<ul class="list-inline pb-3">
								<li class="list-inline-item text-right">Đã đặt trong giỏ hàng <input
									type="hidden" name="quantity" id="product-quanity" value="1">
								</li>
								<li class="list-inline-item "><span
									class="btn btn-success" id="Cart-amount-minus">-</span></li>
								<li class="list-inline-item "><span
									class="btn" style="background-color:white;color:blue;" 
									id="Cart-amount-value">
													 ${amount}
									</span></li>
								<li class="list-inline-item"><span
									class="btn btn-success" id="Cart-amount-plus">+</span></li>
							</ul>
						</div>
					</div>
				</div>
					<div class=" row ">
						<a class="btn btn-success" href="<c:url value="/web/cart"/>" style="color: white;">Go Cart</a>
					</div>
					
					
					
				</div>
		</div>
	</div>
	
	
	
	<!-- 
<script src="https://code.jquery.com/jquery-3.1.1.min.js">
integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous">
</script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script> -->

<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
var urlGet = '<c:url value="/CommentAPI?id_product=${product.getId_product() }" />'
var urlPost = '<c:url value="/CommentAPI" />'
var id_product = ${product.getId_product()}

var cmt_container = document.getElementById("comment-container")
function clearCMT(){
	cmt_container.innerHTML=''
}
function showCMT(dataCMT){
	var data=dataCMT['comment']
	var id_user = data['id_user']
	var full_name=dataCMT['full_name']
	var content=data['content']
	var time_cmt = data['time_cmt']
	var div_cmt = document.createElement("div");
	
	var content_div = `
		<div class="card" style="width: 100%;">
		<div class="card-body">
			<h5 class="card-title float-left" style="font-weight:700; font-size:14px;">`+full_name+`</h5>
			<div style="clear:both;"></div>
			<p class="card-text">`+content+`</p>
			<h5 class="card-title float-right" style="font-weight:700;">Time: `+time_cmt+`</h5>
			<div style="clear: both;"></div>
		</div>
	`
	div_cmt.innerHTML = content_div
	cmt_container.appendChild(div_cmt);
}
function getListCMT(){
	clearCMT()
	$.get(urlGet,(res)=>{
		var list_cmt=JSON.parse(res)
		if(list_cmt==null){
			return;
		}
		for (let data of list_cmt){
			//console.log(data)
			showCMT(data);
		}
	},);
}
getListCMT();

var cmt_text = document.getElementById('comment-write-text')
function sendCMT(){
	alert(urlPost)
	if(content==null || content.trim()==""){
		alert('vui lòng nhập comment');
		//return;
	}
}

$("#comment-write-btn").click(function()
		{
	var content = cmt_text.value
	var data={
		id_product: id_product,
		content: content
	}
			$.ajax({
				  url: urlPost,
				  type: 'post',
				  data: JSON.stringify(data),
				  success: function (data, status) {
					 console.log('done');
					 data =JSON.parse(data);
					 showCMT(data);
					 cmt_text.value="";
				  },
				  error: function (xhr, desc, err) {
				    console.log(xhr);
				    console.log("Desc: " + desc + "\nErr:" + err);
				  }
				});
		}); 
		
	
	var urlCartPost = '<c:url value="/CartAPI" />'

	$("#Cart-amount-plus").click(function(){
		var data={
				id_product: id_product,
				amount: 1
		}
		$.ajax({
			  url: urlCartPost,
			  type: 'post',
			  data: JSON.stringify(data),
			  success: function (data, status) {
				 console.log('done');
				 if(data=='true'){
					var cartAmountElement = document.getElementById("Cart-amount-value");
					 var amount =parseInt(String(cartAmountElement.innerText));
					 cartAmountElement.innerText=amount+1;
					
				 }
				 else {
					 alert("loi");
				 }
			  },
			  error: function (xhr, desc, err) {
			    console.log(xhr);
			    console.log("Desc: " + desc + "\nErr:" + err);
			  }
			});
	});
	
	$("#Cart-amount-minus").click(function(){
		var data={
				id_product: id_product,
				amount: -1
		}
		$.ajax({
			  url: urlCartPost,
			  type: 'post',
			  data: JSON.stringify(data),
			  success: function (data, status) {
				 console.log('done');
				 if(data=='true'){
					var cartAmountElement = document.getElementById("Cart-amount-value");
					 var amount = parseInt(String(cartAmountElement.innerText));
					 cartAmountElement.innerText=amount-1;
				 }
				 else {
					 alert("loi");
				 }
			  },
			  error: function (xhr, desc, err) {
			    console.log(xhr);
			    console.log("Desc: " + desc + "\nErr:" + err);
			  }
			});
	});
</script>


</div>







<!-- End Slider Script -->

