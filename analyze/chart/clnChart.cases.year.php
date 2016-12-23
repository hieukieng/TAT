<?php 
	include("fusioncharts.php");
	// include("../block/chart.php");
	$hostdb="localhost";
	$userdb="root";
	$passdb="";
	$namedb="antoangi_tat";
	$dbCon= new mysqli($hostdb,$userdb,$passdb,$namedb);
  ?>
<html>
<head>
<title>thống kê tai nạn</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <script src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script>
        <script src="http://static.fusioncharts.com/code/latest/fusioncharts.charts.js"></script>
        <script src="http://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.fint.js"></script>
<!--         <script type="text/javascript" src="fusioncharts1/js/fusioncharts.js"></script>
<script type="text/javascript" src="fusioncharts1/js/themes/fusioncharts.theme.fint.js"></script> -->
</head>
<body>
<?php
		$from_year=$_SESSION['from_year'];
		$to_year=$_SESSION['to_year'];
		if($from_year<=$to_year){
			$sql="SELECT Year(date) as year, Count(ID) as count from article where YEAR(date) Between $from_year and $to_year group by Year(date)";
		}
		else{
			$sql="SELECT Year(date) as year, Count(ID) as count from article where YEAR(date) Between $to_year and $from_year group by Year(date) order by year DESC";
		}		
	$result = $dbCon->query($sql) or exit("Error code ({$dbCon->error}): {$dbCon->error}");
	if ($result) {
		# code...
		$arrData = array(
			"chart"=> array(
						"caption"=> "biểu đồ thống kê số vụ tai nạn",
            			"subCaption"=> "từ năm ".$from_year." đến năm ".$to_year ,
            			"xAxisName"=> "năm",
            			"yAxisName"=> "số vụ",
            			"theme"=> "fint", )
			);

		$arrData["data"]= array();
		while ($row=mysqli_fetch_array($result)) {
			# code...
			array_push($arrData["data"], array(
              	"label" => $row["year"],
              	"value" => $row["count"]
              	)
			);
		}
		$jsonEncodedData = json_encode($arrData);
		// echo '<pre>';
		// print_r($jsonEncodedData);
		$columnChart = new FusionCharts("column2d", "myFirstChart" , 600, 300, "chart-1", "json", $jsonEncodedData);

        	// Render the chart
        	$columnChart->render();

      // closing db connection
      $dbCon->close();
	}
?>


  	<div id="chart-1"><!-- Fusion Charts will render here--></div>

 </body>

</html>