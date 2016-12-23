<?php ob_start(); ?>
<?php require('lib/dbCon.php'); ?>
<?php require('lib/function.php'); ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<?php session_start(); ?>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<title>An toàn giao thông</title>
</head>

<body>
    <div id="wrapper">
        <div id="banner"><img src="images/banner2.png" height="140" width="800"/></div>
        
		<?php require('blocks/menu.php'); ?>
        
        <div id="content">
        	<?php 
				if(isset($_GET['timkiem'])&&isset($_GET['q'])){
					$_SESSION['q'] = $_GET['q'];
				}
				
			?>
        	<?php require('blocks/search_result_left_site.php'); ?>
        	<?php require('blocks/right_statistics.php'); ?>
        </div>
        
         <div id="footer" style="font-style:italic; text-align:right;">Trang thông tin về tai nạn giao thông</div>
    </div>
</body>
</html>
<?php ob_flush(); ?>
