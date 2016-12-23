<div id="map">    
     <div id="image_map">
		 <?php
        $year = NULL;
        $from_year = NULL;
        $to_year = NULL;
        
        if(isset($_GET['year'])){$year = $_GET['year'];}
        
        if(($year != NULL)){
            echo "Bạn đã chọn thống kê theo thời gian, cụ thể là năm ".$year;
        }
        
        
        if(isset($_GET['from_year'])){$from_year = $_GET['from_year'];}
        if(isset($_GET['to_year'])){$to_year = $_GET['to_year'];}
        
        if(($from_year != NULL)&&($to_year != NULL)){
            echo "Bạn đã chọn thống kê theo khoảng thời gian, cụ thể là từ năm ".$from_year." đến năm ".$to_year;
        }
        ?>
        <br />Đây là phần hình ảnh
     </div>
   	 <div id="title_map">Đây là phần tiêu đề hình ảnh</div>
</div>