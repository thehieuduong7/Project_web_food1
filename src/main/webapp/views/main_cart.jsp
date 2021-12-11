
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-md " style="margin-top:9em;">
	<div class="row" style="height:500px;">
		 <div class="col-1"></div>
		<div class="col-7">

			<div class="title row">
				<div class="row">
					<div class="col-4">
						<h4 class="row">
							<b>Shopping Cart</b>
						</h4>
						
					</div>
					<div class="col-6">
						<h3 class=" row">Đã đặt trong giỏ hàng</h3>
					</div>
					<div class="col-2">
						<h3 class=" row text-right">Giá tiền</h3>
					</div>
				</div>
			</div>
			
			<div class="row" id="List-cart-container">
				<div>
					<div class="row border-top border-bottom">
						<div class="row main align-items-center">
							<div class="col-2">
								<img class="img-fluid" src="https://i.imgur.com/pHQ3xT3.jpg">
							</div>
							<div class="col-2">
								<div class="row text-muted"></div>
								<div class="row">1</div>
								<div class="col-1">
								&euro; 44.00 <span class="close">&#10005;</span>
							</div>
							</div>
							<div class="col-7">
								
									<ul class=" roww list-inline pb-3">
									
										<li class="list-inline-item "><span
											class="btn btn-success" id="Cart-amount-minus">-</span></li>
										<li class="list-inline-item "><span class="btn"
											style="background-color: white; color: blue;"
											id="Cart-amount-value"> ${cart.getAmount()} </span></li>
										<li class="list-inline-item"><span
											class="btn btn-success" id="Cart-amount-plus">+</span></li>
									</ul>
								</div>
							<div class="col-1">
								&euro; 44.00 <span class="close">&#10005;</span>
							</div>
						</div>
					</div>
				</div>
				
			</div>

		</div>
			
		<div class="col-4">
			<div>
				<h4>
					Thanh toán
				</h4>
			</div>
			<hr>
			<div class="row mb-10">
				<div class="col" style="">
					<h4><strong>Tổng tiền</strong></h4>
				</div>
				<div class="col text-right mr-20" >&euro; 
				<span id="Cart-totalMoney">
				132.00
				</span>
				</div>
			</div>
			<div class="row">

				<div class="col" style="">
					<h4><strong>Shipping</strong></h4>
				</div>
				<div class="col text-right mr-20">&euro;
					<span id="Shipping-price">132.00</span>
				 </div>

				<select class="form-select" aria-label="Default select example">
					<option selected>Open this select menu</option>
					<option value="1">One</option>

				</select> 
			
			</div>
			<div class="row"
				style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
				<div class="col">
				<h4>
				<strong>Tổng tiền thanh toán</strong>
				</h4>
				</div>
				<div class="col text-right mr-20">&euro; 
				<span id="Bill-money-value">
					137.00
				</span></div>
			</div>
			<button class="btn row" id="Bill-pay" style="width:100%;">PAY</button>

		</div>
	</div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
var urlProductAPIbase = '<c:url value="/ProductAPI" />'
function getUrlProduct(id_product){
	return urlProductAPIbase+"?pid="+id_product;
}
function getProductDetail(id_product){
	let dataPro;
	let name_food;
	 $.ajax({
		url:getUrlProduct(id_product),
		type:'get',
		success: function (data, status) {
			 console.log('done');
			 dataPro =JSON.parse(data);
			return dataPro
			
		  },
		  error: function (xhr, desc, err) {
		    console.log(xhr);
		    console.log("Desc: " + desc + "\nErr:" + err);
		  },
		  async: false
	})
	return dataPro
}


var listCartContainer= document.getElementById('List-cart-container')


function showCart(data){
	var product = data['product']
	var id_product = data['id_product']
	var name_food=product['name_food']
	var id_category = product['id_category']
	var price =parseFloat(product['price'])
	var salePercent =parseFloat(product['salePercent'])
	var buyPrice = price*(1-salePercent)
	var amount = data['amount']
	var cart_div = document.createElement("div");
	cart_div.id="cart-item"+id_product
	var content_div=`
		<div class="row border-top border-bottom">
		<div class="row main align-items-center">
			<div class="col-2">
				<img class="img-fluid" src="https://i.imgur.com/pHQ3xT3.jpg">
			</div>
			<div class="col-2">
				<div class="row text-muted" style="font-size:15px;">`+name_food+`</div>
				<div class="row">`+id_category+`</div>
				
				
	
				
			</div>
			<div class="col-6">
				
					<ul class=" roww list-inline pb-3">
					
						<li class="list-inline-item "><span
							class="btn btn-success" id="Cart-amount-minus"
							onclick="minusCart(`+id_product+`)"
							>-</span></li>
						<li class="list-inline-item "><span class="btn"
							style="background-color: white; color: blue;"
							id="Cart-amount-value`+id_product+`"> `+amount+`</span></li>
						<li class="list-inline-item"><span
							onclick="plusCart(`+id_product+`)"
							class="btn btn-success" id="Cart-amount-plus">+</span></li>
					</ul>
				</div>
			<div class="col-2">
			<div display="inline"><span class="row"style="text-decoration-line: 
				`+((salePercent==0)?"none;":"line-through;")+
				`">
				$`+price+`</span> <span class=" row" style="">
				`+((salePercent==0)?"":("$"+buyPrice))+`
							</span>
							
			</div>
				<button type="button" 
				onclick="deleteCart(`+id_product+`)"
				class="" style="display:inline;float:right;">&#10005;</button>
				
			</div>
		</div>
	</div>
	`
	cart_div.innerHTML = content_div
	listCartContainer.appendChild(cart_div)
}


var listCart = (${listCart})
function showListCart(){
	clearCartContainner()
	for (let data of listCart){		
		var id_product = data['id_product']
		var dataProduct = getProductDetail(id_product)
		data = JSON.parse(JSON.stringify(data))
		data['product']=dataProduct
		//console.log("product"+JSON.stringify(data['product']))
		showCart(data);
	}
	updateTotalMoney();
} 


var urlCartAPI = '<c:url value="/CartAPI" />'

function updateTotalMoney(){
	var data;
	$.ajax({
		  url: urlCartAPI,
		  type: 'get',
		  success: function (res, status) {
			 console.log('done');
				data=JSON.parse(res)

		  },
		  error: function (xhr, desc, err) {
		    console.log(xhr);
		    console.log("Desc: " + desc + "\nErr:" + err);
		  },
		  async: false
		});
	 var sumMoney = (!data['totalMoney'])?0:data['totalMoney']
	 document.getElementById('Cart-totalMoney').innerText=sumMoney
}
updateTotalMoney()
showListCart()


function clearCartContainner(){
	listCartContainer.innerHTML=""
	document.getElementById('Cart-totalMoney').innerText=0
}
function deleteCart(id_product){
	if(!confirm("Do you want to remove it?")){
		return;
	}

	$.ajax({
		  url: urlCartAPI+"?pid="+id_product,
		  type: 'delete',
		  success: function (data, status) {
			 console.log('done');
			 if(data=='true'){
				 var cartItem= document.getElementById("cart-item"+id_product);	
				 cartItem.remove()
				 updateTotalMoney()
			 }
			 else {
				 alert("server hiện quá tải! vui lòng thử lại sau");
			 }
		  },
		  error: function (xhr, desc, err) {
		    console.log(xhr);
		    console.log("Desc: " + desc + "\nErr:" + err);
		  },
		  async: false
		});
}

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
					var cartAmountElement = document.getElementById("Cart-amount-value"+id_product);
					 var amount =parseInt(String(cartAmountElement.innerText));
					 cartAmountElement.innerText=amount+1;
					 updateTotalMoney();
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

function minusCart(id_product){
	var cartAmountElement = document.getElementById("Cart-amount-value"+id_product);
	var amount =parseInt(String(cartAmountElement.innerText));
	if(amount==1){
		return deleteCart(id_product)
	}
	var data={
			id_product: id_product,
			amount: -1
	}
	$.ajax({
		  url: urlCartAPI,
		  type: 'post',
		  data: JSON.stringify(data),
		  success: function (data, status) {
			 console.log('done');
			 if(data=='true'){
				 cartAmountElement.innerText=amount-1;
				 updateTotalMoney()
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

var urlBillAPI = '<c:url value="/BillAPI" />'
$('#Bill-pay').click(function(){
	if(!confirm("Xác nhận mua hàng?")){
		return;
	}
	var data={
			city_ship: 'Ha Noi',
	}
	$.ajax({
		  url: urlBillAPI,
		  type: 'post',
		  data: JSON.stringify(data),
		  success: function (data, status) {
			 console.log('done');
			 if(data=='true'){
				 clearCartContainner()	
				 alert("Đặt món thành công!!! vui lòng check mail để xem hoá đơn")
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
})

</script>
