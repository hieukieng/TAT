<div id="time_option">
    <div id="time_option1">
    <form action="statistics.php" method="get">
    	<table>
        	<tr><td style="font-size:18px; font-weight:bold;">Thống kê theo thời gian</td></tr>
            <tr>
            	<td>
                	<?php 
						echo "Năm &nbsp;&nbsp;&nbsp;&nbsp;<select name='year'>";
						for($i=$min_year;$i<=$max_year;$i++){
							echo "<option>".$i."</option>";
						}
						echo "</select>";
					?>
                </td>
            </tr>
            
            <tr>
            	<td>
                	 <input type="submit" name="submit" value="<?php 
					echo "Xem thống kê "; 
					if(isset($_GET['year'])) echo " năm ".$_GET['year'];
					?>" />
                </td>
            </tr>
        </table>
    </form>
    </div>
    
    <div id="time_option2">
    <form action="statistics.php" method="get">
    	<table>
        	<tr><td colspan="3" style="font-size:18px; font-weight:bold;">Thống kê theo khoảng thời gian</td></tr>
            <tr>
            	<td>
                	<?php 
						echo "Từ năm &nbsp;&nbsp;&nbsp;&nbsp;<select name='from_year'>";
						for($i=$min_year;$i<=$max_year;$i++){
							echo "<option>".$i."</option>";
						}
						echo "</select>";
					?>
                </td>
                <td><?php echo '&nbsp;&nbsp;'?></td>
                <td>
                	<?php 
						echo "Đến năm &nbsp;&nbsp;&nbsp;&nbsp;<select name='to_year'>";
						for($i=$min_year;$i<=$max_year;$i++){
							echo "<option>".$i."</option>";
						}
						echo "</select>";
					?>
                </td>
            </tr>
            <tr>
            	<td colspan="3">
                	<input type="submit" name="submit" value="<?php 
					echo "Xem thống kê "; 
					if(isset($_GET['from_year'])) echo " năm ".$_GET['from_year'];
					if(isset($_GET['to_year'])) echo " năm ".$_GET['to_year'];
					?>" />
                </td>
            </tr>
        </table>
    </form>
    </div>
</div>