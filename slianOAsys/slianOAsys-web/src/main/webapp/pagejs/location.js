var searchService,map,markers = [];
var init = function() {
    var center = new qq.maps.LatLng(29.886850,121.637350);
    map = new qq.maps.Map(document.getElementById('container'),{
        center: center,
        zoom: 13
    });
var geocoder = new qq.maps.Geocoder({
        complete : function(result){
            if(confirm("确认将经纬度更改当前位置吗？"+result.detail.address)){
                $("#latitude").val(result.detail.location.getLat().toFixed(6));
                $("#longitude").val(result.detail.location.getLng().toFixed(6));
            } 
        }
    });
    qq.maps.event.addListener(map,'click',function(event) {
        var latLng = event.latLng,
            lat = latLng.getLat().toFixed(6),
            lng = latLng.getLng().toFixed(6);
        geocoder.getAddress(latLng);
    }); 
    var latlngBounds = new qq.maps.LatLngBounds();
    var latlngs = [];
    //调用Poi检索类
    searchService = new qq.maps.SearchService({
        complete : function(results){
            var pois = results.detail.pois;
            for(var i = 0,l = pois.length;i < l; i++){
                var poi = pois[i];
                latlngBounds.extend(poi.latLng);

               (function(n) {
                    var marker = new qq.maps.Marker({
                        map: map,
                        position:poi.latLng
                    });
                    marker.setTitle(i+1);
                    markers.push(marker);
                    qq.maps.event.addListener(marker, 'click', function() {
                        geocoder.getAddress(marker.getPosition());
                        
                    });
                })(i);      
            }
            map.fitBounds(latlngBounds);
        }
    }); 
}
function init_location(){
	init();
}
//清除地图上的marker
function clearOverlays(overlays){
    var overlay;
    while(overlay = overlays.pop()){
        overlay.setMap(null);
    }
}
function searchKeyword() {
    var keyword = document.getElementById("keyword").value;
    var region = document.getElementById("region").value;
    clearOverlays(markers);
    searchService.setLocation(region);
    searchService.search(keyword);
}

$(function () {
    init();
    $.ajax({
        url: BASE_URL + 'locationSetting.do',
        type: 'GET',
        dataType: "json",
        success: function (data) { 
            $("#latitude").val(data.latitude);
            $("#longitude").val(data.longitude);
            $("#distacne").val(data.distance);
            $("#status  option[value='"+data.status+"']").attr("selected",true);
            }
        });
});
    $(document).on('click','#locationSubmint',function () {
        if($("#latitude").val()!=null&&$("#longitude").val()!=null&&$("#distacne").val()!=null
                &&$("#latitude").val()!=""&&$("#longitude").val()!=""&&$("#distacne").val()!=""){
            $.ajax({
              url :  BASE_URL + 'updateLocationSetting.do',
              type: 'GET',
              dataType: 'json',
              data:{latitude:$("#latitude").val(),
                  "longitude":$("#longitude").val(),
                  distacne:$("#distacne").val(),
                  status:$('#status option:selected').val()
                  },
              async:false,
              error: function(r,sta){
                console.info("fail");
                alert("信息填写错误，距离请填写整数");
              },
              success : function(re) {
                  alert(re.message);
              }
            });
        }else{
            alert("请将信息填写完整");
        }
     });







