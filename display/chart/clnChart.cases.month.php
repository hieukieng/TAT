<?php 
	include("fusioncharts.php");
	// include("C:\xampp\htdocs\TAT1\blocks\chart.php");
	$hostdb="localhost";
	$userdb="antoangi_thang";
	$passdb="tat2016";
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
	$year = $_SESSION['year'];
	$sql="SELECT Month(date) as month, Count(ID) as count from article where YEAR(date)= $year group by Month(date)";
	$result = $dbCon->query($sql) or exit("Error code ({$dbCon->error}): {$dbCon->error}");
	if ($result) {
		$arrData = array(
			"chart"=> array(
						"caption"=> "biểu đồ thống kê số vụ tai nạn",
            			"subCaption"=> "năm ".$year,
            			"xAxisName"=> "tháng",
            			"yAxisName"=> "số vụ",
            			"theme"=> "fint", )
			);
		$arrData["data"]= array();
		while ($row=mysqli_fetch_array($result)) {
			# code...
			array_push($arrData["data"], array(
              	"label" => $row["month"],
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