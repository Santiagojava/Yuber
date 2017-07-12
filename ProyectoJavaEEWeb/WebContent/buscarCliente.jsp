<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String nombre_cli = (String)request.getSession().getAttribute("nombre_cli");
	String longitud = (String)request.getSession().getAttribute("longitud");
	String latitud = (String)request.getSession().getAttribute("latitud");
%>
<html>
    <head>
        <link rel="stylesheet" href="css/map.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        <title> YUBER - Buscar Cliente</title>
        <script src="http://maps.googleapis.com/maps/api/js"> </script>    
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/main.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
    var labels = 'AB';
    var labelIndex = 0;
      function initMap() {
        var longitud =<%=longitud%>;
        var latitud =<%=latitud%>;
       	var lon = parseFloat(longitud);
       	var lati = parseFloat(latitud);
        var myLatLngA = {lat: lati, lng: lon};
        var myLatLngB = {lat: -34.34280006325033, lng: -56.71580890100001};

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 16,
          center: myLatLngA
        });

        var marker = new google.maps.Marker({
          position: new google.maps.LatLng(lati,lon),
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
    <script>
		$(document).on("click", "#actualizar", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	        $.get("InicioServicio", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
       			$("#mensaje").text(responseText);
	        });
	    });
	</script>
	<script>
		$(document).on("mouseenter", "#mensaje", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
	        $.get("FinalizarServicio", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
	        	if(responseText == "indexProv.jsp"){
	    			window.location.replace("indexProv.jsp");
	    		}
	    		else{
	    			$("#mensaje").text(responseText);
	    		}
	        });
	    });
	</script>
    </head>
<body>
	<div class="jumbotron" align="center">
		<div id="map" class="map"></div>
	    <h1 id="mensaje">De click al boton Iniciar Servicio cuando se encuentre con el cliente</h1>
        <button id="actualizar" class="btn btn-danger">Iniciar Servicio</button>
	</div>
	<!--  <div id="mensaje"></div>-->
	<footer>
        <div class="contenedorPie">
            <p class="copy"> YUBER! &copy; 2017</p>
            <div class="sociales">
            </div>
        </div>
    </footer>
</body>
</html>