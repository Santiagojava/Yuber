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
        <title> YUBER - pedido</title>
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
    </head>
    <body>
        <header>
            <nav class="navbar navbar-default navbar-static-top menus" role="navigation">
                <div class="container-fluid">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navegacion-Lm">
                                <span class="sr-only"> Desplegar / Ocultar menu</span>
                                <samp class="icon-bar"></samp>
                                <samp class="icon-bar"></samp>
                                <samp class="icon-bar"></samp>
                            </button>
                            <a href="indexProv.jsp" class="navbar-brand">Yuber</a>
                        </div>
                        <! -- Inicia Menu -->
                        <div class="collapse navbar-collapse" id="navegacion-Lm">
                        <ul class="nav navbar-nav">
                            <li><a href="index.jsp">Historial</a></li>
                        </ul>
                        <form action="Buscador" class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input name="palabra" type="text" class="form-control" placeholder="Buscar">
                            </div>
                            <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search"></span></button></a>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <div class="jumbotron" align="center">
            <h4>PEDIDO</h4>
            <form method="post" action="AceptaProveedor">
            	<input type="hidden" name="nombre_cli" value="<%=nombre_cli%>">
            	<input type="hidden" name="longitud" value="<%=longitud%>">
            	<input type="hidden" name="latitud" value="<%=latitud%>">
            	<input type="submit" class="btn btn-danger" value="Aceptar">
            </form>	
            <a href="indexProv.jsp" class="btn btn-default">Cancelar</a>
            <h5><%=nombre_cli%></h5>
            <div id="map" class="map"></div>
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