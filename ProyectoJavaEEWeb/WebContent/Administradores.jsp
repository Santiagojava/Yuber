<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="css/map.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        <title> YUBER - transporte</title>
        <script src="http://maps.googleapis.com/maps/api/js"> </script>    
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/main.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
    var labels = 'AB';
    var labelIndex = 0;
      function initMap() {
        var myLatLngA = {lat: -34.34280006325033, lng: -56.70970890000001};
        var myLatLngB = {lat: -34.34280006325033, lng: -56.71580890100001};

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: myLatLngA
        });

        var marker = new google.maps.Marker({
          position: new google.maps.LatLng(-34.34280006325033,-56.70970890000001),
          map: map,
          draggable: true,
          label: labels[labelIndex++ % labels.length],
          animation: google.maps.Animation.DROP,
        });
        
        marker.addListener('click', toggleBounce);
        marker.addListener( 'dragend', function (event)
        {
            //escribimos las coordenadas de la posicion actual del marcador dentro del input #coords
            document.getElementById("A-coordsX").value = this.getPosition().lat();
            document.getElementById("A-coordsY").value = this.getPosition().lng();
        });


      }
            //callback al hacer clic en el marcador lo que hace es quitar y poner la animacion BOUNCE
            function toggleBounce() {
              if (marker.getAnimation() !== null) {
                marker.setAnimation(null);
              } else {
                marker.setAnimation(google.maps.Animation.BOUNCE);
              }
            }
             
             $("#myModal").on("shown.bs.modal", function () {
    google.maps.event.trigger(map, "resize");
});
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDaWWetuqWf6A1CBWxb145XNliMshSL_gY&callback=initMap">
    </script>
    </head>
    <body>
        <div class="jumbotron">
            <ul class="nav nav-tabs nav-justified">
                <li role="presentation" class="active"><a href="transporte.html">TRANSPORTE</a></li>
                <li role="presentation"><a href="on-site.html">ON-SITE</a></li>
                <li role="presentation" ><a href="remote.html">REMOTO</a></li>
            </ul>
            <br>
            <div class="info">
                
<button type="submit" class="btn btn-danger navbar-right" id="solicitar"><span class="glyphicon glyphicon-thumbs-up"></span>Solicitar</button>
                <h3><span class="glyphicon glyphicon-map-marker"></span> Ingresar Ubicacion </h3>
                <br>
                <div id="map" class="map"></div>
               <br>
               <br>
                <a href="#">Latitud:</a><input id="A-coordsX" type="text" disabled class="form-control input-sm" placeholder="Latitud">
                <a href="#">Longitud:</a><input id="A-coordsY" type="text" disabled class="form-control input-sm" placeholder="Longitud">
               
            </div>
        </div>
        <footer>
            <div class="contenedorPie">
                <p class="copy"> YUBER! &copy; 2017</p>
                <div class="sociales">
                </div>
            </div>
        </footer>
    </body>
</html>