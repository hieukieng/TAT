<?php 
  $hostdb="localhost";
  $userdb="root";
  $passdb="";
  $namedb="antoangi_tat";
  $dbCon= new mysqli($hostdb,$userdb,$passdb,$namedb);
  ?>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Bảng thống kê</title>
      <style>
        table, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
        }
      </style>
     </head>
     <body>
        <?php
          $year = $_SESSION['year'];
          $sql="SELECT Month(date) as month, Count(ID) as count from article where YEAR(date)= $year group by Month(date)";
          $result = $dbCon->query($sql) or exit("Error code ({$dbCon->error}): {$dbCon->error}"); 

          echo "<table border='1'>
          <tr>
          <th>Tháng</th>
          <th>Số vụ tai nạn</th>
          </tr>";
          while($row = mysqli_fetch_array($result))
          {
          echo "<tr>";
          echo "<td>" . $row['month'] . "</td>";
          echo "<td>" . $row['count'] . "</td>";
          echo "</tr>";
          }
          echo "</table>";
          mysqli_close($dbCon);
        ?>
    </body>
</html>