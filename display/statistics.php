<?php require('lib/dbCon.php') ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Statistics</title>
</head>

<body>
	
	<div id="wrapper_statistics">
   	  <div id="banner"><img src="images/banner2.png" width="786" height="140"/></div>
    	<?php require('blocks/menu.php'); ?>
    	<div id="content_statistics">
        	<?php require('blocks/time_option.php');?>
        	<?php require('blocks/map.php'); ?>
            <?php require('blocks/chart.php'); ?>
        </div>
        <div id="footer_statistics">Đây là phần footer</div>
    </div>
</body>
</html>