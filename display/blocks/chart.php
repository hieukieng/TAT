<div id="chart">
    <div id="image_chart">
       <?php
        $year = NULL;
        $from_year = NULL;
        $to_year = NULL;

        
        if(isset($_GET['year'])){

            $year = $_GET['year'];

            $_SESSION['year'] =  $year;

        }

        
        if(($year != NULL)){
             require('chart/clnChart.cases.month.php'); 
        }
        
        
        if(isset($_GET['from_year']))
        {
            $from_year = $_GET['from_year']; 

            $_SESSION['from_year'] =  $from_year;
        }

        if(isset($_GET['to_year']))
        {
            $to_year = $_GET['to_year'];

            $_SESSION['to_year'] =  $to_year;

        }
        
        if(($from_year != NULL)&&($to_year != NULL)){
            require('chart/clnChart.cases.year.php');
        }
        ?>
		<br />Đây là phần hình ảnh
    </div>

    <div id="title_chart">Đây là phần tiêu đề hình ảnh</div>
    
</div>