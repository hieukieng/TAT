(function () {

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: {lat: 21.027990, lng: 105.833680}//21.027990, 105.833680
    });
    var geocoder = new google.maps.Geocoder();

    function initMap() {
        document.getElementById('submit').addEventListener('click', function () {
            geocodeAddress(geocoder, map);
        });
    }

    var infowindow = new google.maps.InfoWindow;

    downloadUrl("phpsqlajax_genxml2.php", function (data) {
        var xml = data.responseXML;
        var markers = xml.documentElement.getElementByTagName("marker");
        for (var i = 0; i < markers.length; i++) {
            var id = markers[i].getAttribute("id");
            var loca_name = markers[i].getAttribute("name");

            var geocoder = new google.maps.Geocoder();
            geocodeAddress(geocoder, map, loca_name);
        }

    });

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
                bindInfoWindow(marker,map,infowindow,html);
            } else {
                alert('Geocode was not successful for the following reason: ' + status);
            }
        });
    }

    function downloadUrl(url, callback) {
        var request = window.ActiveXObject ?
            new ActiveXObject('Microsoft.XMLHTTP') : new XMLHttpRequest();
        request.onreadystatechange = function () {
            callback(request, request.status);

            request.open('GET', url, true);
            request.send(null);
        }
    }

    function bindInfoWindow(marker, map, infoWindow, html) {
        google.maps.event.addListener(marker, 'click', function () {
            infoWindow.setContent(html);
            infoWindow.open(map, marker);
        });
    }
    initMap();
});