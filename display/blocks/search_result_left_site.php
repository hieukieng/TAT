<div id ="left">
	<?php
		$query = NULL;
		$mark_word = NULL;
		$query_pos = NULL;		
		if(isset($_GET['query'])){
			$query = $_GET['query'];
			if($query == 'place'){
				if(isset($_GET['key_word'])){
					$place= $_GET['key_word'];
					$mark_word = $place; //danh dau tu can tim
					$query_pos = '&query=place&key_word='.$place; //truyen tham so cho url 
				}
				$sql = "select * from article where title regexp '$place'";
			}
			if($query == 'time'){
				if(isset($_GET['year'])){
					$year= $_GET['year'];
					$query_pos = '&query=time&year='.$year; //truyen tham so cho url 
				}
				$year .= '%';
				$sql = "select * from article where date like '$year'";
			}
		}else{
			if(isset($_SESSION['q'])){
				$search_key = $_SESSION['q'];
				$sql = "select * from article where title regexp '$search_key'";
				$mark_word = $search_key;
				$query_pos = '$search_key='.$search_key; //truyen tham so cho url 
			}
		} 
		
		$number = mysqli_query($conn,$sql);
		$total_records = mysqli_num_rows($number); 
		
		if($total_records == 0){
			$site = "<div id='number_of_news'></div>";
			$site .= "<div id='left-content'><p style='font-size: 20px;'>Không tìm thấy kết quả</p>";
			$site .= "<div id='pagination'></div>";
			echo $site;
		}else{
			$current_page = isset($_GET['page']) ? $_GET['page'] : 1;
        	$limit = 5;
        	$total_page = ceil($total_records / $limit);
		
			if ($current_page > $total_page){$current_page = $total_page;}
        	
			if ($current_page < 1){$current_page = 1;}
		
        	$start = ($current_page - 1) * $limit;
	?>
	<div id="number_of_news" style="text-align:right; font-size:16px; font-style:italic;"><?php echo $total_records . " bài báo"; ?></div>
	<div id="left-content">
    	<ul>  
		<?php
			if($query == 'place'){
				$data = mysqli_query($conn, "SELECT * FROM article where title regexp '$place' order by date desc LIMIT $start, $limit");
			}
			else if($query == 'time'){
				$data = mysqli_query($conn, "SELECT * FROM article where date like '$year' order by date desc LIMIT $start, $limit");
			}else{
				$data =  mysqli_query($conn, "SELECT * FROM article where title regexp '$search_key' order by date desc LIMIT $start, $limit");
			}	
		?>
    
    	<?php 
			while($news = mysqli_fetch_assoc($data)){	
		?>
        	<div id="box_news">
            	<div id="news_title"><a href="<?php echo $news['source_link']; ?>" target="_blank">
				<?php 
					if($mark_word != NULL){
						$marked_word = find_word($news['title'],$mark_word);
						echo str_replace($marked_word,'<mark>'.$marked_word.'</mark>',$news['title']);
					}else{
						echo $news['title'];
					}
				?></a></div>
                <div id="news_image"><img src="<?php echo $news['image_url'];?>" width="160" height="170" /></div>
                <div id="news_summary">
                <table border="1">
                
                	<tr>
                    	<td id="short_cell" colspan="2" >Thời gian:</td>
                        <td id="short_cell" >Số người  chết: </td>
                    </tr>
                    	
                    <tr>
                    	<td id="short_cell" colspan="2" >Địa điểm:</td>
                        <td id="short_cell" >Số người bị thương: </td>
                    </tr>
                    
                    <tr><td colspan="3" id="long_cell">Phương tiện: </td></tr>
                    
                    <tr><td colspan="3" id="long_cell">Nguyên nhân: </td></tr>
                    
                    <tr>
                    	<td id="info" colspan="2">User: thang96bk</td>
                    	<td id="do_summary"><a href="form_summary.php"><input type="button" value="Tóm tắt" /></a></td>
                    </tr>
                </table>
                
                </div>
              
            </div>
		<?php
        }
		?>
       
		</ul>
	</div>
    <div id="pagination">
   		<?php
			$range = 15;
			 if($total_page <= $range){
				$min = 1;
				$max = $total_page; 	
			 }else{
				$mid_range = ceil($range/2);
				if($current_page <= $mid_range){
					$min = 1;
					$max = $range;
				}else{
					$min = $current_page - $mid_range + 1;
					$max = $current_page + $mid_range - 1;
					if($max > $total_page){
						$max = $total_page;
					}
				}
			}
		
			if($current_page > 1 && $total_page > 1){
				$pagination = '<a href="search_result_site.php?page='.($current_page-1).$query_pos;
				$pagination .= '"><input id="page_button" type="button" value="Prev"></a>';
				echo $pagination; 		
			}
			
			for($i=$min;$i<=$max;$i++){
				if($i == $current_page){
					$pagination = '<input id="page_button" type="button" value="'.$i.'" style="background:#0C9;">';
				}else{
					$pagination = '<a href="search_result_site.php?page='.$i.$query_pos;					
					$pagination .= '"><input id="page_button" type="button" value='.$i.'></a>';
				}
				echo $pagination;
			}
			
			if($current_page < $total_page && $total_page > 1){
				$pagination = '<a href="search_result_site.php?page='.($current_page+1).$query_pos;
				$pagination .= '"><input id="page_button" type="button" value="Next"></a>';
				echo $pagination;  		
			}
		}//end of total_records!=0
		?>
    </div>
</div>