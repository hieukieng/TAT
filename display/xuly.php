<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Traffic Accident Tracking System</title>
	<link rel="stylesheet" type="text/css" href="style.css"/>
</head>

<body>
	<div id="wrapper">
    	<div id="banner"></div>
        
        <div id="menu">
        	<div id="menu-bar">
                <ul>
                    <li><a href="#">Trang chủ</a></li>
                    <li><a href="#">Khu vực</a></li>
                    <li><a href="#">Năm</a></li>
                    <li><a href="#">Thống kê</a></li>
                    <li><a href="#">Giới thiệu</a></li>
                </ul>
             </div>
            <div id="search">Tìm kiếm</div>
        </div>    
            <div id="left">
                <ul>
                <?php
					$conn = mysql_connect("localhost","root","") or die("Khong the ket noi");
					mysql_query("SET NAMES 'UTF8'");
					mysql_select_db("traffic_accident") or die("Khong tim thay CSDL");
					
					$data = mysql_query("select * from newsheader");
					$newsheader = mysql_fetch_assoc($data);
					include('simple_html_dom.php');
					while($newsheader = mysql_fetch_assoc($data)){
						$html = file_get_html($newsheader['sourceLink']);
						$html->find('.baiviet-bailienquan',0)->outertext='';
						$html->load($html->save());
						$newsContent = $html->find('.text-conent',0);
									
						echo $newsheader['newsTitle'].'<br>';
						echo $newsheader['newsDescription'];
						echo $newsContent;
					}
		
				?>

                </ul>
            </div>
            <!--Left End -->
        
        <!--Right Begin -->
        <div id="right">
        	<table border="1" width="400" height="460"> 
            	<tr>
                	<td colspan="2">Thống kê tháng 1</td>
                </tr>
                
                <tr>
                	<td>Số vụ tai nạn</td>
                    <td>6</td>
                </tr>
                
                <tr>
                	<td>Số người chết</td>
                    <td>3</td>
                </tr>
                
                <tr>
                	<td>Số người bị thương</td>
                    <td>8</td>
                </tr>
                
                <tr>
                	<td colspan="2">Các thành phố lớn</td>
                </tr>
                
                <tr>
                	<td>Hà Nội</td>
                    <td>2 vụ</td>
                </tr>
                
                <tr>
                	<td>Tp Hồ Chí Minh</td>
                    <td>4 vụ</td>
                </tr>
            </table>
        </div>
        <!-- Right End -->
        <div id="footer">Footer</div>
</body>
</html>
