<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer" style="justify-content:center;width:100%;">
						<form action="<c:url value="/seller/products"/>" method="post" 
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
										name="text_price" placeholder="name@example.com">
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1">Description</label> <input
										type="text" class="form-control"
										name="text_description" placeholder="name@example.com">
								</div>
								<div class="form-group">
									<label for="exampleFormControlFile1">Photo</label>
									<input type="file" class="form-control-file"
										name="file_photo_add">
								</div>
								<div class="form-group">
									<label for="exampleFormControlInput1">Sale percent</label> <input
										type="text" class="form-control"
										name="text_salePercent" placeholder="percent">
								</div>
								 <button type="submit"  class="btn btn-primary mb-2"
								 	onclick="checkConfirm(event)"
								 >Add</button>
								 <button type="button" class="btn btn-primary mb-2" data-dismiss="modal">Close</button>
							</form>
						</div>
					</div>
				</div>
			</div>


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