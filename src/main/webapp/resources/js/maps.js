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
                lng: item['lng'],
                icon: 'resources/img/map/red.png',
                click: function(marker) {
                    var markersArray = MAP_INSTANCE.markers;
                    for (var i = 0; i < markersArray.length; i++) {
                        markersArray[i].setIcon('resources/img/map/red.png');
                    }
                    MAP_INSTANCE.setZoom(8);
                    marker.setIcon('resources/img/map/green.png');
                    MAP_INSTANCE.map.panTo(marker.position);
                    $('#largeModal').modal();
                    refreshMap();
                }
            });
        }
        MAP_INSTANCE.setZoom(4);
        refreshMap();
    }
    return MAP_INSTANCE;
};

var resetZoomOnMap = function(list) {
    if (null != MAP_INSTANCE) {
        MAP_INSTANCE.setZoom(4);
        refreshMap();
    }
    return MAP_INSTANCE;
};

var mockData = function() {
    var list = [];
    list.push({
        lat: 20.385181,
        lng: 72.911453
    });
    list.push({
        lat: 18.296974,
        lng: 83.896782
    });
    return list;
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
                populateMap(mockData());
            });
            $('#map').show();
            getMap();
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            //TODO
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
