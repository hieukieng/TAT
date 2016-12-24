<!--Begin: menu -->
<div id="menu">
	<!--Begin: menu-bar -->
  <div id="menu-bar">
     <ul>
  	   <li><a href="index.php">Trang chủ</a></li>
       <div id="border"></div>                    
       <li><a href="#">Khu vực</a>
         	<ul>
             	<li><a href="search_result_site.php?query=place&key_word=Hà Nội">Hà Nội</a></li>              
                <li><a href="search_result_site.php?query=place&key_word=Hồ Chí Minh">Tp. Hồ Chí Minh</a></li>
            </ul>
       </li>
       <div id="border"></div> 
       <li><a href="#">Năm</a>
         	<ul>
				<?php 
                    for($i=$max_year;$i>=$min_year;$i--){
                        
                ?>
          		<li><a href="search_result_site.php?query=time&year=<?php echo $i; ?>"><?php echo $i; ?></a></li>
                <?php 
					}
				?>
    	    </ul>
        </li>
        <div id="border"></div> 
        <li><a href="statistics.php">Thống kê</a></li>
        <div id="border"></div> 
        <li><a href="#">Giới thiệu</a></li>
      </ul>
     </div>
      <!--End: menu-bar -->
  	 <div id="search">
     <form action="search_result_site.php" method="get">   
    	<input id="search_cell" type="text" name="q" placeholder="Nhập nội dung tìm kiếm" maxlength="120" >
    	<input id="search_button" type="submit" value="Tìm" name="timkiem">
	 </form>
     </div>
</div>
<!--End: menu -->