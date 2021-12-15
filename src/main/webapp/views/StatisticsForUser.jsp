    <!-- load Google AJAX API -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>  


<div class="container" style="margin-top:15em;">

<div class="row mt-5">
		<div class="row">
			<div class="" style="justify-content:center;display:flex">
				<h1 class="display-1" style="margin-bottom: 20px; font-weight:bold; font-size:40px;
				 color:#192a56">THỐNG KÊ ĐÃ MUA</h1>
			</div>
			
			<table class="table table-bordered mt-5" style="width: 70%;margin-left: 20px;">
				<thead>
					<tr>
						<th style="width: 15%;">Month</th>
						<th style="width: 15%;">Year</th>
						<th style="width: 30%;">Total amount</th>
						<th style="width: 40%;">Total money</th>
					</tr>
				</thead>
				<tbody id="table-thang">

				</tbody>
			</table>
			
			
		</div>
		<div class="row" id="chart-thang"></div>


</div>


    
 </div>    
	<!--Div for our chart -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

 <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
    
    	// init char google
    	
    	    	//load the Google Visualization API and the chart
        google.load('visualization', '1', {'packages': ['columnchart']});

    		//init		bien doanh thu thang

	  	
	  	
    	const urlDoanhThu = '<c:url value="/StatisticsAPI" />'
    	
    	function getDataDoanhThuThang(){
    		var data
    		$.ajax({
  			  url: urlDoanhThu+"?kind=thongKeDaMua",
  			  type: 'get',
  			  success: function (res, status) {
   				 console.log(urlDoanhThu+"?kind=thongKeDaMua")

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
		

		var dataThang = getDataDoanhThuThang()
    	
    	
    	function updateDataThang(data){
        	var total_amount=data['total_amount']
        	var total_money=data['total_money']
    		var month= data['month']
        	var year= data['year']
    		var table_thang = document.getElementById('table-thang')
    		var div= document.createElement("tr")
    		content=`
    			<td style="width:15%;">`+month+`</td>
                <td style="width:15%;">`+year+`</td>
                <td style="width:30%;">`+total_amount+`</td>
                <td style="width:40%;">`+total_money+` đồng</td>
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
            dataTableThang.addColumn('string','thang');
            dataTableThang.addColumn('number', 'Tổng tiền đã mua(VND)');
           	//dataTableThang.addColumn('number', 'Tổng số lượng');

            //define rows of data
            var detail =dataThang['detail']
            for (let i of detail){
            	var year = i['year']
            	var month= String(i['month'])
            	var time = "Tháng "+month+" năm "+year; 
            	var total_money=i['total_money']
            	var total_amount=i['total_amount']

            	dataTableThang.addRow([time,total_money])
            }
            
            //dataTableThang.addRows([['JSP & Servlet', 20], ['Spring',12],['Struts',7]]);
            //instantiate our chart object
            var chart = new google.visualization.ColumnChart(document.getElementById('chart-thang'));

            //define options for visualization
            var options = {height: 500, is3D: true, title: 'Thống kê đã mua'};
            //draw our chart
            chart.draw(dataTableThang, options);
        }
        
        google.setOnLoadCallback (createChartThang);
        updateTableThang()

        

        
    </script>