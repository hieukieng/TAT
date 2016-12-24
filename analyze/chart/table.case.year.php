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

         $from_year=$_SESSION['from_year'];
         $to_year=$_SESSION['to_year'];
         $sql="SELECT Year(date) as year, Count(ID) as count from article where YEAR(date) Between $from_year and $to_year group by Year(date)"; 
         $result = $dbCon->query($sql) or exit("Error code ({$dbCon->error}): {$dbCon->error}");

          echo "<table border='1'>
          <tr>
          <th>Năm</th>
          <th>Số vụ tai nạn</th>
          </tr>";
          while($row = mysqli_fetch_array($result))
          {
          echo "<tr>";
          echo "<td>" . $row['year'] . "</td>";
          echo "<td>" . $row['count'] . "</td>";
          echo "</tr>";
          }
          echo "</table>";
          mysqli_close($dbCon);
        ?>
    </body>
</html>