<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				</div>
				<div style="height: 70px">
					<span style="text-decoration-line:
						`+((salePercent==0)?"none;":"line-through")+
						`">
						`+price+
						`đồng </span> <span
						style="display:
							`+((salePercent==0)?"None":"Block")+
						`;" >
						`+buyPrice+`đồng </span>


				</div>

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

