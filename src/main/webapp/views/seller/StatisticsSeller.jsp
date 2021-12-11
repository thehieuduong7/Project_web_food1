    <!-- load Google AJAX API -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>  


<div class="container" style="margin-top:15em;">

<div class="row mt-50">
    
	    <div class="row">
			<h1> Bảng chi tiết</h1>
		</div>
	    <table class="table table-dark row">
	            <thead>
	               <tr>
	                  <th>No</th>
	                  <th>Language</th>
	                  <th>Percent</th>
	               </tr>
	            </thead>
	            <tbody>
	               <tr>
	                  <td>1</td>
	                  <td>Java</td>
	                  <td>14.21%</td>
	               </tr>

	            </tbody>
	         </table>
    </div>
	<div class="row" style="margin-top:40px;">

		<div class="row">
			<h1>Biểu đồ thống kê doanh thu</h1>
		</div>
		<div class="row" id="chart"></div>

	</div>
	<!--Div for our chart -->
   
    
    
    
    
    
    
   
</div>

 <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
        //load the Google Visualization API and the chart
        google.load('visualization', '1', {'packages': ['columnchart']});

        //set callback
        google.setOnLoadCallback (createChart);

        //callback function
        function createChart() {

            //create data table object
            var dataTable = new google.visualization.DataTable();

            //define columns
            dataTable.addColumn('string','Quarters 2009');
            dataTable.addColumn('number', 'Doanh thu VND');

            //define rows of data
            dataTable.addRows([['JSP & Servlet', 20], ['Spring',12],['Struts',7]]);

            //instantiate our chart object
            var chart = new google.visualization.ColumnChart (document.getElementById('chart'));

            //define options for visualization
            var options = {height: 500, is3D: true, title: 'Java Technologies for Web Applications'};

            //draw our chart
            chart.draw(dataTable, options);

        }
    </script>