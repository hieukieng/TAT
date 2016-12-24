<div id="left">
	<div id="number_of_news" style="text-align:right; font-size:16px; font-style:italic;"><?php echo $total_records . " bài báo"; ?></div>
	<div id="list_news">
		<ul>
		<?php 
			while($news = mysqli_fetch_assoc($data)){	
		?>
        	<div id="box_news">
            	<div id="news_title"><a href="<?php echo $news['source_link']; ?>" target="_blank" onmousemove="<?php echo "Xem chi tiết" ?>" ><?php echo $news['title']; ?></a></div>
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
			echo '<a href="'.'index.php?page='.($current_page-1).'">'.'<input id="page_button" type="button" value="Prev"></a>'; 		
		}
		
		for($i=$min;$i<=$max;$i++){
			if($i == $current_page){
				echo '<input id="page_button" type="button" value="'.$i.'" style="background:#0C9;">';
			}else{
				echo '<a href="'.'index.php?page='.$i.'">'.'<input id="page_button" type="button" value="'.$i.'"></a>';
			}
		}
		
		if($current_page < $total_page && $total_page > 1){
			echo '<a href="'.'index.php?page='.($current_page+1).'">'.'<input id="page_button" type="button" value="Next"></a>'; 		
		}
		?>
    </div>
</div>

