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

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body onload="initMap()">

<div id="floating-panel">
    <form action="phpsqlajax_genxml2.php" method="POST">

        <input id="datepicker" name="datepicker" type="text" value="">

        <input id="datepicker2" name="datepicker2" type="text" value="">

        <input id="submit" type="button" value="Filter" onclick="listenSelect()">
    </form>
</div>

<div id="map"></div>

<script>
    $( function() {
        $( "#datepicker" ).datepicker();
        $( "#datepicker2" ).datepicker();
    } );
</script>

<!---->
<!--<script src="pikaday.js"></script>-->

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDWWbW0CdyYO2EVkILAuJ-algzJ4_pcGU&libraries=visualization&callback=initMap">
</script>

<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDDWWbW0CdyYO2EVkILAuJ-algzJ4_pcGU&libraries=visualization">
</script>

<script type="text/javascript">

    var map;
    var geocoder = new google.maps.Geocoder();
    var infowindow = new google.maps.InfoWindow();

    var heatmapData = [
        new google.maps.LatLng(21.026546, 105.805377),
        new google.maps.LatLng(21.036800, 105.833530),
        new google.maps.LatLng(21.030712, 105.845718),
        new google.maps.LatLng(21.013246, 105.828380),
        new google.maps.LatLng(21.005596, 105.843315),
        new google.maps.LatLng(21.003993, 105.850954),
        new google.maps.LatLng(21.000508, 105.847714),
        new google.maps.LatLng(21.000848, 105.842435),
        new google.maps.LatLng(21.004414, 105.842006),
        new google.maps.LatLng(21.004334, 105.838852),
        new google.maps.LatLng(21.001890, 105.841234),
        new google.maps.LatLng(21.004855, 105.840311),
        new google.maps.LatLng(21.005916, 105.848679),
        new google.maps.LatLng(21.002371, 105.849216)
    ];

    var heatmap = new google.maps.visualization.HeatmapLayer({
        data: heatmapData
    });

    function eventSubmit() {

        downloadUrl("phpsqlajax_genxml2.php", function (data) {

            var xml = data.responseXML;
            var markers = xml.documentElement.getElementsByTagName("marker");
            var geocode = new google.maps.Geocoder();
            for (var i = 0; i < markers.length; i++) {

                var id = markers[i].getAttribute("id");
                var local_name = markers[i].getAttribute("name").toString();
                geocodeAddress(geocode, map, local_name);

            }

        });

    }

    function initMap() {

        map = new google.maps.Map(document.getElementById('map'), {
            zoom: 15,
            center: {lat: 21.027990, lng: 105.833680}//21.027990, 105.833680
        });

        heatmap.setMap(map);
        eventSubmit();
    }

    function geocodeAddress(geocoder, resultsMap, name) {

        geocoder.geocode({'address': name}, function (results, status) {

            if (status === 'OK') {
                resultsMap.setCenter(results[0].geometry.location);

                var html = "<b>" + name + "</b> <br/>";
                var infowindow = new google.maps.InfoWindow({
                    content: html
                });
                var marker = new google.maps.Marker({
                    map: resultsMap,
                    position: results[0].geometry.location

                });
                marker.addListener('click', function() {
                    infowindow.open(resultsMap, marker)
                });
            } else {

            }
        });

    }

    function downloadUrl(url, callback) {

        var request = window.ActiveXObject ?
            new ActiveXObject('Microsoft.XMLHTTP') :
            new XMLHttpRequest;

        //request.setRequestHeader("Content-Time",sql);
        request.onreadystatechange = function () {

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
    function doNothing() {
    }
    //xu ly ngay thang



</script>

<?php
    function showDate($date,$format='m-d-y, h:i a') {
        if(empty($date)) return ' ';
        return date($format,strtotime($date));
    }
?>

<script>


    function listenSelect() {

    }


</script>
</body>
</html>
