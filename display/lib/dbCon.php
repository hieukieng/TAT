 <?php
		$conn = mysqli_connect('localhost', 'root', '', 'antoangi_tat');
		mysqli_set_charset($conn, 'UTF8');
		$data = mysqli_query($conn, 'select * from article order by date DESC');
		
        $total_records = mysqli_num_rows($data);
		
        $current_page = isset($_GET['page']) ? $_GET['page'] : 1;
        $limit = 5;
        $total_page = ceil($total_records / $limit);
		
        if ($current_page > $total_page){
            $current_page = $total_page;
        }
        else if ($current_page < 1){
            $current_page = 1;
        }
 
        $start = ($current_page - 1) * $limit;
		
        $data = mysqli_query($conn, "SELECT * FROM article LIMIT $start, $limit");
		
		 
		$sql1 = 'select left(max(date),4) as max_year, substring(max(date),6,2) as max_month, 
		left(min(date),4) as min_year, substring(min(date),6,2) as min_month from article'; 
		
		$data1 = mysqli_query($conn,$sql1);
		$row1 = mysqli_fetch_assoc($data1);
		
		$max_year = $row1['max_year'];
		$max_month = $row1['max_month'];
		$min_year = $row1['min_year'];
		$min_month = $row1['min_month'];
 
?>