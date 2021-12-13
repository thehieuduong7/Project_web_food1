    <!-- load Google AJAX API -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>  


<div class="container" style="margin-top:15em;">

<div class="row mt-5">
		<div class="row">
			<div class="" style="justify-content:center;display:flex">
				<h1 class="display-1" style="margin-bottom: 20px; font-weight:bold; font-size:40px;
				 color:#192a56">THỐNG KÊ THÁNG</h1>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="thongKeThang-inputThang" class="col-1 col-form-label"
						style="font-size: 14px; font-weight: 400; display: inline;">Month:</label>
					<div class="col-sm-5">
						<input type="number" min="1" max="12" class="form-control"
							id="thongKeThang-inputThang" placeholder="nhập năm" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="thongKeThang-inputNam" class="col-1 col-form-label"
						style="font-size: 14px; font-weight: 400; display: inline;">Year:</label>
					<div class="col-sm-5">
						<input type="number" min="1" max="12" class="form-control"
							id="thongKeThang-inputNam" placeholder="nhập năm">
					</div>
					
					<button class=" coL-2 btn btn-primary" onclick="table_thang_click()"
					style="padding: 3px 10px; font-size: 14px;
					margin-left:14px;">Xem</button>
				</div>
			</div>
			<table class="table table-bordered mt-5" style="width: 70%;margin-left: 20px;">
				<thead>
					<tr>
						<th style="width: 10%;">ID product</th>
						<th style="width: 40%;">Name product</th>
						<th style="width: 20%;">Total amount</th>
						<th style="width: 30%;">Total money</th>
					</tr>
				</thead>
				<tbody id="table-thang">

				</tbody>
			</table>
			
			
		</div>
		<div class="row" id="chart-thang"></div>
		

		<div class="row" style=" margin-top: 50px; border: 1px solid #0d6efd; width:100%;"></div>

		<div class="row" style="margin-top:40px;">
			<div style="display:flex;justify-content:center;">
				<h1 class="display-1"
					style="margin-bottom: 20px; font-weight: bold; font-size: 40px; color: #192a56">THỐNG
					KÊ NĂM</h1>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="thongKeNam-inputNam" class="col-form-label"
						style="font-size: 14px; font-weight: 400; display: inline;">Year:</label>
					<div class="col-sm-5">
						<input type="number" min="1" max="12" class="form-control"
							id="thongKeNam-inputNam" placeholder="nhập năm">
					</div>
					<button class="btn btn-primary" onclick="table_nam_click()"
					style="padding: 3px 10px; font-size: 14px;
					margin-left:14px;">Xem</button>
				</div>
				
			</div>
			<table class="table table-bordered mt-5" style="width: 70%;margin-left: 20px;">
				<thead>
					<tr>
						<th style="width: 10%;">Month</th>
						<th style="width: 20%;">Total amount</th>
						<th style="width: 70%;">Total money</th>
					</tr>
				</thead>
				<tbody id="table-nam">

				</tbody>
			</table>			
		</div>
		<div class="row" id="chart-nam"></div>

</div>


    
 </div>    
	<!--Div for our chart -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

 <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
    
    	// init char google
    	
    	    	//load the Google Visualization API and the chart
        google.load('visualization', '1', {'packages': ['columnchart']});

    	//init input thong ke thang
		var d=new Date()
		month=d.getMonth()+1
		year=d.getFullYear()
		document.getElementById('thongKeThang-inputThang').value=month
		document.getElementById('thongKeThang-inputNam').value=year	
    		//init		bien doanh thu thang

	  	
	  	
    	const urlDoanhThu = '<c:url value="/StatisticsAPI" />'
    	
    	function getDataDoanhThuThang(month,year){
    		var data
    		$.ajax({
  			  url: urlDoanhThu+"?kind=thongKeThang&month="+month+"&year="+year,
  			  type: 'get',
  			  success: function (res, status) {
   				 console.log(urlDoanhThu+"?kind=thongKeThang&month="+month+"&year="+year)

  				 console.log(res)
  				 data=JSON.parse(res)
  			  },
  			  error: function (xhr, desc, err) {
  			    console.log(xhr);
  			    console.log("Desc: " + desc + "\nErr:" + err);
  			  },
  			  async: false
  			});
    		return data
    	}
		

		var TKThang_inputThang = document.getElementById('thongKeThang-inputThang')
    	var TKThang_inputNam = document.getElementById('thongKeThang-inputNam')
    	month=parseInt(TKThang_inputThang.value)
    	year=parseInt(TKThang_inputNam.value)
		var dataThang = getDataDoanhThuThang(month,year)
    	
    	
    	function updateDataThang(data){
    		var id_product= data['id_product']
        	var name_food= data['name_food']
        	var total_amount=data['total_amount']
        	var total_money=data['total_money']
    		var table_thang = document.getElementById('table-thang')
    		var div= document.createElement("tr")
    		content=`
    			<td style="width:10%;">`+id_product+`</td>
                <td style="width:40%;">`+name_food+`</td>
                <td style="width:15%;">`+total_amount+`</td>
                <td style="width:30%;">`+total_money+` đồng</td>
    		`
    		div.innerHTML= content
    		table_thang.appendChild(div)
    	}
    	function updateTableThang(){
    		document.getElementById('table-thang').innerHTML=""
    		var detail =dataThang['detail']
            for (let i of detail){
            	updateDataThang(i)
            }
    	}
        
	
        //callback function
        function createChartThang() {
            //create data table object
        	var dataTableThang = new google.visualization.DataTable();

            //define columns
            dataTableThang.addColumn('string','Product');
            dataTableThang.addColumn('number', 'Doanh thu VND');
            //define rows of data
            var detail =dataThang['detail']
            for (let i of detail){
            	var name_food= i['name_food']
            	var total_money=i['total_money']
            	dataTableThang.addRow([name_food,total_money])
            }
            
            //dataTableThang.addRows([['JSP & Servlet', 20], ['Spring',12],['Struts',7]]);
            //instantiate our chart object
            var chart = new google.visualization.ColumnChart(document.getElementById('chart-thang'));

            //define options for visualization
            var options = {height: 500, is3D: true, title: 'Doanh thu tháng'};
            //draw our chart
            chart.draw(dataTableThang, options);
        }
        
        

        function table_thang_click(){
        	month=parseInt(TKThang_inputThang.value)
        	year=parseInt(TKThang_inputNam.value)
			dataThang = getDataDoanhThuThang(month,year)
	        google.setOnLoadCallback (createChartThang);
            updateTableThang()
        }
		
		table_thang_click()
		
		
		//init input thong ke nam
		var d=new Date()
		year=d.getFullYear()
		document.getElementById('thongKeNam-inputNam').value=year	
    	var TKNam_inputNam = document.getElementById('thongKeNam-inputNam')

    	function getDataDoanhThuNam(year){
    		var data
    		$.ajax({
  			  url: urlDoanhThu+"?kind=thongKeNam&year="+year,
  			  type: 'get',
  			  success: function (res, status) {
   				 //console.log(urlDoanhThuThang+"?kind=thongKeThang&month="+month+"&year="+year)
  				 console.log(res)
  				 data=JSON.parse(res)
  			  },
  			  error: function (xhr, desc, err) {
  			    console.log(xhr);
  			    console.log("Desc: " + desc + "\nErr:" + err);
  			  },
  			  async: false
  			});
    		return data
    	}
		year=parseInt(TKNam_inputNam.value)
		var dataNam = getDataDoanhThuNam(year)
		
		function updateDataNam(data){
    		var month= data['month']
        	var total_amount=data['total_amount']
        	var total_money=data['total_money']
    		var table = document.getElementById('table-nam')
    		var div= document.createElement("tr")
    		content=`
    			<td style="width:10%;">`+month+`</td>
                <td style="width:20%;">`+total_amount+`</td>
                <td style="width:70%;">`+total_money+` đồng</td>
    		`
    		div.innerHTML= content
    		table.appendChild(div)
    	}
    	function updateTableNam(){
    		document.getElementById('table-nam').innerHTML=""
    		var detail =dataNam['detail']
            for (let i of detail){
            	updateDataNam(i)
            }
    	}
    	
        //callback function
        function createChartNam() {
            //create data table object
        	var dataTable = new google.visualization.DataTable();

            //define columns
            dataTable.addColumn('string','Tháng');
            dataTable.addColumn('number', 'Doanh thu VND');
            //define rows of data
            var detail =dataNam['detail']
            for (let i of detail){
            	var month= String(i['month'])
            	var total_money=i['total_money']
            	dataTable.addRow([month,total_money])
            }
            
            //dataTableThang.addRows([['JSP & Servlet', 20], ['Spring',12],['Struts',7]]);
            //instantiate our chart object
            var chart = new google.visualization.ColumnChart(document.getElementById('chart-nam'));

            //define options for visualization
            var options = {height: 500, is3D: false, title: 'Doanh thu Năm'};
            //draw our chart
            chart.draw(dataTable, options);
        }
        function table_nam_click(){
        	year=parseInt(TKNam_inputNam.value)
			dataNam = getDataDoanhThuNam(year)
	        google.setOnLoadCallback (createChartNam);
            updateTableNam()
        }
		
    	table_nam_click()
		
        
    </script>