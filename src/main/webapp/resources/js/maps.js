var MAP_MINIMUM_ZOOM = 4;
var MAP_MAXIMUM_ZOOM = 6;

var MAP_INSTANCE = null;
var MAP_STYLES = [{
    featureType: 'landscape.man_made',
    elementType: 'geometry',
    stylers: [{
        color: '#f7f1df'
    }]
}, {
    featureType: 'landscape.natural',
    elementType: 'geometry',
    stylers: [{
        color: '#d0e3b4'
    }]
}, {
    featureType: 'landscape.natural.terrain',
    elementType: 'geometry',
    stylers: [{
        visibility: 'off'
    }]
}, {
    featureType: 'poi',
    elementType: 'labels',
    stylers: [{
        visibility: 'off'
    }]
}, {
    featureType: 'poi.business',
    elementType: 'all',
    stylers: [{
        visibility: 'off'
    }]
}, {
    featureType: 'poi.medical',
    elementType: 'geometry',
    stylers: [{
        color: '#fbd3da'
    }]
}, {
    featureType: 'poi.park',
    elementType: 'geometry',
    stylers: [{
        color: '#bde6ab'
    }]
}, {
    featureType: 'road',
    elementType: 'geometry.stroke',
    stylers: [{
        visibility: 'off'
    }]
}, {
    featureType: 'road',
    elementType: 'labels',
    stylers: [{
        visibility: 'off'
    }]
}, {
    featureType: 'road.highway',
    elementType: 'geometry.fill',
    stylers: [{
        color: '#ffe15f'
    }]
}, {
    featureType: 'road.highway',
    elementType: 'geometry.stroke',
    stylers: [{
        color: '#efd151'
    }]
}, {
    featureType: 'road.arterial',
    elementType: 'geometry.fill',
    stylers: [{
        color: '#ffffff'
    }]
}, {
    featureType: 'road.local',
    elementType: 'geometry.fill',
    stylers: [{
        color: 'black'
    }]
}, {
    featureType: 'transit.station.airport',
    elementType: 'geometry.fill',
    stylers: [{
        color: '#cfb2db'
    }]
}, {
    featureType: 'water',
    elementType: 'geometry',
    stylers: [{
        color: '#a2daf2'
    }]
}];

var LOCATIONS_CACHE = {};

var getMap = function() {
    if (null == MAP_INSTANCE) {
        MAP_INSTANCE = new GMaps({
            el: '#map',
            lat: 22,
            lng: 77,
            zoom: 4
        });
        MAP_INSTANCE.addStyle({
            styledMapName: 'Styled Map',
            styles: MAP_STYLES,
            mapTypeId: 'map_style'
        });
        MAP_INSTANCE.setStyle('map_style');
    }
    return MAP_INSTANCE;
};

var refreshMap = function() {
    if (null != MAP_INSTANCE) {
        MAP_INSTANCE.refresh();
    }
    return MAP_INSTANCE;
};

var populateMap = function(list) {
    if (null != MAP_INSTANCE) {
        MAP_INSTANCE.removeMarkers();
        for (var i = 0; i < list.length; i++) {
            var item = list[i];
            MAP_INSTANCE.addMarker({
                lat: item['lat'],
                lng: item['lon'],
                icon: 'resources/img/map/red.png',
				infoWindow: {
				    content: item['content']
				},
                click: function(marker) {
                    var markersArray = MAP_INSTANCE.markers;
                    for (var i = 0; i < markersArray.length; i++) {
                        markersArray[i].setIcon('resources/img/map/red.png');
                    }
                    MAP_INSTANCE.setZoom(MAP_MAXIMUM_ZOOM);
                    marker.setIcon('resources/img/map/green.png');
                    MAP_INSTANCE.map.panTo(marker.position);
                    //$('#largeModal').modal();
                    refreshMap();
                }
            });
        }
        MAP_INSTANCE.setZoom(MAP_MINIMUM_ZOOM);
        refreshMap();
    }
    return MAP_INSTANCE;
};

var resetZoomOnMap = function(list) {
    if (null != MAP_INSTANCE) {
        MAP_INSTANCE.setZoom(MAP_MINIMUM_ZOOM);
        refreshMap();
    }
    return MAP_INSTANCE;
};

var loadLocations = function(selectedId, refreshData) {
    if (!refreshData && LOCATIONS_CACHE[selectedId] && 0 != LOCATIONS_CACHE[selectedId].length) {
        populateMap(LOCATIONS_CACHE[selectedId]);
        return;
    }

    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: 'categories/' + selectedId.substring(3),
        success: function(responseData) {
            var locationsFinal = [];
            var locations = responseData.data.locns;
            for (var idx = 0; idx < locations.length; idx++) {
                var location = locations[idx];
                locationsFinal.push({
                    lat: parseFloat(location.lat),
                    lon: parseFloat(location.lon),
                    content: '<p style="font-weight: bold; line-height: 1; margin: 5px 0;">' 
                    	+ location.area + '</p><p style="line-height: 1; margin: 5px 0;">' 
                    	+ location.value + ' ' + location.unit + '</p>'
                });
            }
            LOCATIONS_CACHE[selectedId] = locationsFinal;
            populateMap(locationsFinal);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        }
    });
}

$(document).ready(function() {
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: 'categories',
        success: function(responseData) {
            var options = '';
            var idx = 0;
            var datalist = responseData.dataList;
            for (idx = 0; idx < datalist.length; idx++) {
                options += '<li><a href="#' + datalist[idx].catId + '" id="cat' + datalist[idx].catId + '">' + datalist[idx].catDesc + '</a></li>';
            }
            $('#categoryMenu').append(options);
            $('#categoryMenu li a').on('click', function(e) {
                $('#categoryTxt').text($(this).text());
                $('#categoryTxt').val($(this).text());
                $('#categoryTxt').attr('selectedId', $(this).attr('id'));
                loadLocations($(this).attr('id'), true);
            });
            $('#map').show();
            getMap();
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        }
    });

    $('#categoryTxt').on('click', function(e) {
        var selectedId = $('#categoryTxt').attr('selectedId');
        if (selectedId && 'Choose Category' != selectedId) {
            resetZoomOnMap();
        }
        $(this).trigger('blur');
    });
});
