<?php
require("./phpsqlajax_dbinfo.php");
function parseToXML($htmlStr)
{
    $xmlStr = str_replace('<', '&lt;', $htmlStr);
    $xmlStr = str_replace('>', '&gt;', $xmlStr);
    $xmlStr = str_replace('"', '&quot;', $xmlStr);
    $xmlStr = str_replace("'", '&apos;', $xmlStr);
    $xmlStr = str_replace("&", '&amp;', $xmlStr);
    return $xmlStr;
}

$connection = mysqli_connect("localhost", $username, $password);
if (!$connection) {
    die('Not connect: ' . mysqli_error());
    echo 'alert("Ko the ket noi")';
}else {

}

$db_selected = mysqli_select_db( $connection,$database);
if (!$db_selected) {
    die ('Cant use db: ' . mysqli_error());
}
//select all row in the marker tables
mysqli_query($connection,"SET NAMES 'UTF8'");

$query = "SELECT * FROM location";

$result = mysqli_query($connection,$query);

if (!$result) {
    die('invalid query: ' . mysqli_error());
}

header("Content-type: text/xml");

echo '<markers>';

// Iterate through the rows, printing XML nodes for each

while ($row = @mysqli_fetch_assoc($result)) {
    // ADD TO XML DOCUMENT NODE

    echo '<marker ';
    echo 'id="' . $row['id'] . '" ';
    echo 'name="' . $row['name'] . '" ';
    echo 'fulltime="' . $row['fulltime'] . '" ';
    echo '/>';
}

// End XML file
echo '</markers>';
mysqli_close($connection);

//if($_REQUEST['datepicker']){
//    echo $_POST['datepicker'];
//}

?>

