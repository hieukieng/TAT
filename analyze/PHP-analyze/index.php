<!DOCTYPE html>
<html>
<head>
    <title>Geocoding service</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
        html, body {
            height: 100%;
            margin: 0%;
            padding: 3%;
        }

        #map {
            height: 500px;
        }

        #data {
            margin-top: 2cm;
            height: 2cm;
        }

        #floating-panel {
            position: absolute;
            top: 10px;
            left: 25%;
            z-index: 5;
            background-color: #fff;
            border: 1px solid #999;
            text-align: center;
            font-family: 'Roboto', 'sans-serif';
            line-height: 30px;
            padding: 5px 5px 5px 10px;
        }
    </style>
</head>
<body onload="initMap()">

<div id="floating-panel">
    <input id="address" type="text" value="Sydney, NSW">
    <input id="submit" type="button" value="Geocode">
</div>
<div id="map"></div>
<div id="dataa"></div>
<!--        <script>
            function initMap() {
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 8,
                    center: {lat: -34.397, lng: 150.644}
                });
                var geocoder = new google.maps.Geocoder();

                document.getElementById('submit').addEventListener('click', function () {
                    geocodeAddress(geocoder, map);
                });
            }

            function geocodeAddress(geocoder, resultsMap) {
                var address = document.getElementById('address').value;
                geocoder.geocode({'address': address}, function (results, status) {
                    if (status === 'OK') {
                        resultsMap.setCenter(results[0].geometry.location);
                        var marker = new google.maps.Marker({
                            map: resultsMap,
                            position: results[0].geometry.location
                        });
                    } else {
                        alert('Geocode was not successful for the following reason: ' + status);
                    }
                });
            }
        </script>-->
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDWWbW0CdyYO2EVkILAuJ-algzJ4_pcGU&callback=initMap">
</script>

<?php
//$conn = mysqli_connect("localhost", "root", "", "databaselocation") or die('Cannot connect');
//
//        mysql_query("SET NAMES 'UTF8'");
//
//        $sql = 'SELECT * FROM location';
//
//        $result = mysqli_query($conn, $sql);
//
//        if (!$result) {
//            die('Sai câu truy vấn');
//        }
//
//// Start XML file, echo parent node
//        echo '<p><markers>';
//
//// Iterate through the rows, printing XML nodes for each
//        while ($row = @mysqli_fetch_assoc($result)) {
//            // ADD TO XML DOCUMENT NODE
//            echo '<marker ';
//            echo 'id="' . $row['id'] . '" ';
//            echo 'name="' . $row['name'] . '" ';
//            echo '/>';
//        }
//
//// End XML file
//        echo '</markers></p>';
//        mysqli_close($conn);
?>
<script type="text/javascript">

    var map;
    var geocoder = new google.maps.Geocoder();
    var infowindow = new google.maps.InfoWindow;

    function initMap() {

        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: {lat: 21.027990, lng: 105.833680}//21.027990, 105.833680
        });

        document.getElementById('submit').addEventListener('click', function () {
            geocodeAddress(geocoder, map,document.getElementById('address').value);
        });
        document.getElementById('dataa').innerHTML="Van Thanh";
        downloadUrl("phpsqlajax_genxml2.php", function (data) {

            var xml = data.responseXML;

            var markers = xml.documentElement.getElementsByTagName("marker");

            for (var i = 0; i < markers.length; i++) {
                var id = markers[i].getAttribute("id");
                var local_name = markers[i].getAttribute("name");
                var geocode = new google.maps.Geocoder();
                geocodeAddress(geocode, map, local_name);
            }

        });
    }

    function geocodeAddress(geocoder, resultsMap, name) {

        //var address = document.getElementById('address').value;
        geocoder.geocode({'address': name}, function (results, status) {
            if (status === 'OK') {
                resultsMap.setCenter(results[0].geometry.location);
                var marker = new google.maps.Marker({
                    map: resultsMap,
                    position: results[0].geometry.location
                });
                var html = "<b>" + name + "</b> <br/>" + address;
                bindInfoWindow(marker, map, infowindow, html);
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    }

    function downloadUrl(url, callback) {

        var request = window.ActiveXObject ?
            new ActiveXObject('Microsoft.XMLHTTP') :
            new XMLHttpRequest;

        request.onreadystatechange = function() {

            if (request.readyState == 4) {

                request.onreadystatechange = doNothing;
                callback(request, request.status);
            }
        };

        request.open('GET', url, true);
        request.send(null);
    }

    function bindInfoWindow(marker, map, infoWindow, html) {

        google.maps.event.addListener(marker, 'click', function () {
            infoWindow.setContent(html);
            infoWindow.open(map, marker);
        });
    }
    function doNothing() {}


</script>
</body>
</html>
