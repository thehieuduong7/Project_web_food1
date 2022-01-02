<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    



<!-- menu section starts  -->
<section style="text-align: center;margin-top: 170px;" class="menu dishes"
  id="menu">
  
    <h3 class="sub-heading"> My menu </h3>

    <h1 class="heading"> today's speciality </h1>
	
	<div class="input-group">
          <div id="navbar-search-autocomplete" class="form-outline">
<!--                     <label class="form-label" for="form1">Search</label>
 -->
				<input type="search"
				 style="height: 40px; margin-top: 8px; padding-left:14px;
				 	font-size:14px; font-weight:500;
					width:200px;" placeholder="search food"
					id="text_search" class="form-control" />

			</div>
          <button type="button" id="btn_search"
          	onclick="click_search()"
           class="btn btn-primary">
            <i class="fas fa-search"></i>
          </button>
    </div>
	
    <section class="catalog">
        <div id="Category-container">
        </div>
    </section>

    <div id="Product_container" class="box-container">
    	
    </div>
    <button style="margin-top: 50px; padding: 10px 40px;" id="Product_load_btn" onclick="" class="btn btn-primary">Load more</button>
</section>
<!-- menu section ends -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
var listAllCategory = ${listCategory}
var cate_container = document.getElementById("Category-container")
//  <button onclick="" class="btn-cate btn btn-primary">Tất cả</button>
var categoryCurrent = -1



var urlProductAPI='<c:url value="/ProductAPI" />'
var pageCurrent=0;
var maxInPage=4;
var lenPage=1;

var urlBaseProject = '<c:url value="/" />'
var product_container = document.getElementById("Product_container")
function loadProduct(data){

	var photo = urlBaseProject+data['photo']
	var id_product = data['id_product']
	var name_food = data['name_food']
	var price = parseFloat(data['price'])
	var salePercent = parseFloat(data['salePercent'])
	var buyPrice = price*(1-salePercent)
	var div = document.createElement("div");
	div.classList.add('box')
	div.id = name_food

	var content = 
	`
			<a href="<c:url value="/web/productDetail?pid=`+id_product+`" />"
					class="fas fa-eye"></a> <img src="`+
						photo
					+`" alt=""
					width="100px" height="100px">
				<h3>`+name_food+`</h3>
				<div class="stars">
					<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star"></i> <i class="fas fa-star"></i> <i
						class="fas fa-star-half-alt"></i>
=======
<%@include file="/common/taglib.jsp"%>


<div class="container" style="margin-top: 100px;">
	<div class="d-flex justify-content-between">
		<div class="alert alert-primary" role="alert">
		${mess }</div>
		<div class=""></div>
		<div class="" style="">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal">
				<icon class="fas fa-plus"></icon>
				Add new food
			</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true" >
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel"></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer" style="justify-content:center;width:100%;">
						<form action="<c:url value="/seller/products"/>" method="post" style="width: 80%;"
						enctype="multipart/form-data">							
								<h3>Nhập thông tin sản phẩm mới</h3>
								<input type="hidden" id="form_meth" name="form_meth" value="add">
								
								<div style="wdith:100%; border:1px solid black; margin:15px 0px"></div>
								<div class="form-group" style="width:100%;">
									<label for="exampleFormControlInput1">Name food</label> <input
										type="text" class="form-control"
										name="text_name_food" placeholder="name food">
								</div>
								<div class="form-group">
									<label for="exampleFormControlSelect1">Category</label>
									 <select class="form-control"
										class="form-control" name="select_category">
										<c:forEach items="${listCate }" var="cate">

										<option value="${cate.getId_category() }">${cate.getName_category() }</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1">Price</label> <input
										type="text" class="form-control"
										name="text_price" placeholder="price">
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1">Description</label> <input
										type="text" class="form-control"
										name="text_description" placeholder="description">
								</div>
								<div class="form-group">
									<label for="exampleFormControlFile1">Photo</label>
									<input type="file" class="form-control-file"
										name="file_photo_add">
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1">Sale percent</label> <input
										type="text" class="form-control"
										name="text_salePercent" placeholder="sale percent">
								</div>
								 <button type="submit"  class="btn btn-primary mb-2" style="min-width:150px;"
								 	onclick="checkConfirm(event)"
								 >ADD</button>
								 <button type="button" style="min-width:150px;" class="btn btn-primary mb-2" data-dismiss="modal">CLOSE</button>
							</form>
						</div>
					</div>
>>>>>>> 91a82881ecd7555689d15a13e1d689f987ea98e2
				</div>
			</div>


<<<<<<< HEAD
				<button class="btn" onclick="plusCart(`+
						id_product+
						`)">
					<i class="fas fa-shopping-basket"></i> Thêm vào giỏ
				</button>		
	`
	div.innerHTML=content
	Product_container.appendChild(div)
}
var product_load_btn = document.getElementById("Product_load_btn")

function resetIndex(){
	product_container.innerHTML=""
		pageCurrent=0;
		lenPage=1;
}

function loadProductByCID(cid,search){
	if(!cid) {
		cid=categoryCurrent
	}
	if(categoryCurrent!=cid)
		{
		resetIndex()
		}
	categoryCurrent	=cid
	pageCurrent+=1;
	data={
			id_category:cid,
			maxInPage:maxInPage,
			page:pageCurrent
	}
	var list_cate
	$.ajax({
		  url: urlProductAPI,
		  type: 'Post',
		  data: JSON.stringify(data),
		  success: function (data, status) {
			  if(!!data){
				data =JSON.parse(data);
				lenPage = data['lenPage']
				if(pageCurrent<=lenPage){
					for (var i of data['listByCID']){
						loadProduct(i);
					}
					if(pageCurrent==lenPage){
						product_load_btn.setAttribute('style','display:None;')
					}
					else product_load_btn.setAttribute('style','display:inline-block;')

				}
				else{
					product_load_btn.setAttribute('style','display:None;')
				}
			  }
		
		  },
		  error: function (xhr, desc, err) {
			  
		    console.log(cid);
		    console.log("Desc: " + desc + "\nErr:" + err);
		  }
		});
}
//loadProductByCID()
product_load_btn.setAttribute('onclick',"loadProductByCID()")

function createButtonCategory(data){
	var id_category = data['id_category']
	var name_category= data['name_category']
	var icon = data['icon']
	var btn = document.createElement("button");
	btn.setAttribute('class','btn-cate btn btn-primary ml-2 mr-2')
	btn.setAttribute('style','min-width:150px;')
	content =`	<icon class="`
					+icon+
				`"></icon>
		`+name_category
	btn.innerHTML = content
	btn.setAttribute('onclick',"loadProductByCID("+id_category+")")
	cate_container.appendChild(btn)
}

function initCategoryContainer(){
	all = {
			id_category:-1,
			name_category:'All',
			icon:""
	}
	createButtonCategory(all)
	for(var data of listAllCategory){
		createButtonCategory(data)
	}
}
initCategoryContainer()


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
		
		
var listAllPro= loadProductByCID(-1);	
text_search =document.getElementById(listAllPro)



function click_search(){
	var search = document.getElementById('text_search');
	var str_search = search.value
	//if(!str_search) return;
	var listBox = product_container.getElementsByClassName('box')
	for (var i of listBox){
		if(i.id.startsWith(str_search)){
			i.setAttribute('style','display:block;')
		}else{
			i.setAttribute('style','display:none;')

		}
	}
}

</script>

=======
		</div>

		<!-- Button trigger modal -->

	</div>
	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th style="width:200px;">Photo</th>
				<th style="width:100px;">ID food</th>
				<th style="width:300px;">Name food</th>
				<th style="width:100px;">ID category</th>
				<th style="width:200px;">Price</th>
				<th style="width:400px;">Description</th>
				<th style="width:30px;">Sale percent</th>
				<th style="width:200px;">Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listProduct }" var="pro">
			<tr style="height:150px;">
				<td> 
				<form id="form${pro.getId_product() }" action="<c:url value="/seller/products"/>"
				 method="post" enctype="multipart/form-data">	
				 <input type="hidden"  name="text_id_product" value="${pro.getId_product()}">
				<input type="hidden" id="form_meth_${pro.getId_product()}" name="form_meth">
				<img src="<c:url value="${pro.getPhoto()}"/>" 
				width= "150px" height="120px">
				<input type="file" class="form-control-file" 
				 name="file_photo_add">
				</form> 
				
				</td>
				<td>
				
					${pro.getId_product() }
				
				</td>
				
				<td>
						<div class="form-group">
							<input
								type="text" class="form-control" name="text_name_food"
								form="form${pro.getId_product() }"
								placeholder="name food" value="${pro.getName_food()}">
						</div> 
				</td>
				<td>
				<select class="form-control" class="form-control"
				form="form${pro.getId_product() }"
						name="select_category">
							<c:forEach items="${listCate }" var="cate">
								<option value="${cate.getId_category() }"
								 ${((cate.getId_category()==pro.getId_category())?"selected":"")}
								>${cate.getName_category() }</option>
							</c:forEach>
					</select> </td>
				<td>
						<div class="form-group">
							<input
								type="text" class="form-control" name="text_price"
								form="form${pro.getId_product() }"
								placeholder="Price" value="${pro.getPrice()}">
						</div>  </td>
					<td>
						<div class="form-group">
							<input type="text" class="form-control" name="text_description"
							form="form${pro.getId_product() }"
								placeholder="description" value="${pro.getDescription() }">
						</div> 
					</td>
					<td>
						<div class="form-group">
							<input type="text" class="form-control" name="text_salePercent"
							form="form${pro.getId_product() }"
								placeholder="name food" value=" ${pro.getSalePercent()}">
						</div> 
					</td>
					<td><button type="submit" form="form${pro.getId_product() }" 
					style="    padding: 5px 15px; min-width:150px;"
					class="btn btn-primary mb-2"
					 onclick='changeMethod(event,"form_meth_${pro.getId_product()}","update")'>
					 <icon class="fas fa-edit"></icon>
					 
					 Edit</button>
					<button type="submit"
					style="    padding: 5px 15px; min-width:150px;
						background-color:#d73535;
					"
					 form="form${pro.getId_product() }" 
					onclick='changeMethod(event,"form_meth_${pro.getId_product()}","delete")'
					class="btn btn-danger mb-2">
					<icon class="fas fa-trash-alt"></icon>
					Remove</button>
					
				</td>
				
			</tr>
			</c:forEach>
		</tbody>

	</table>

	<form id="my_form">
		<input type="text" name="fname" placeholder="First Name" required>
		<input type="text" name="lname" placeholder="Last name" required>
		<input type="text" name="company" placeholder="Company"> <input
			type="text" name="email" placeholder="E-mail" required> <input
			class="pull-right" type="submit" name="submit"
			value="Complete Subscription">
	</form>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function changeMethod(event,id,value){
		if(!confirm("Are you sure???")){
			event.preventDefault()
			return;
		}
		var input =document.getElementById(id);
		input.value=value;
	}
	function checkConfirm(event){
		if(!confirm("Are you sure???")){
			event.preventDefault()
			return;
		}
	}
</script>
>>>>>>> 91a82881ecd7555689d15a13e1d689f987ea98e2
