<?php ob_start(); ?>
<?php require('lib/dbCon.php') ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>An toàn giao thông</title>
</head>

<body>
	
	<div id="wrapper">
   	  <div id="banner"><img src="images/banner2.png" width="786" height="140"/></div>
    	<?php require('blocks/menu.php'); ?>
    	<div id="content">
        	<?php require('blocks/left_list_news.php'); ?>
            <?php require('blocks/right_statistics.php'); ?>
        </div>
        <div id="footer" style="font-style:italic; text-align:right;">Trang thông tin về tai nạn giao thông</div>
    </div>
</body>
</html>
<?php ob_flush(); ?>