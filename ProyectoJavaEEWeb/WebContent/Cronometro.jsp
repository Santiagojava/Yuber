<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="css/map.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/estilo.css">
  <title> YUBER - transporte</title>
  <script src="http://maps.googleapis.com/maps/api/js"> </script>    
  <script src="js/main.js"></script>
  <script src="js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/cronometro.js"></script>
<script>
var centesimas = 0;
var segundos = 0;
var minutos = 0;
var horas = 0;
control = setInterval(cronometro,10);
if (centesimas < 99) {
 centesimas++;
 if (centesimas < 10) { centesimas = "0"+centesimas }
 Centesimas.innerHTML = ":"+centesimas;
}
if (centesimas == 99) {
 centesimas = -1;
}
if (centesimas == 0) {
 segundos ++;
 if (segundos < 10) { segundos = "0"+segundos }
 Segundos.innerHTML = ":"+segundos;
}
if (segundos == 59) {
 segundos = -1;
}
if ( (centesimas == 0)&&(segundos == 0) ) {
 minutos++;
 if (minutos < 10) { minutos = "0"+minutos }
 Minutos.innerHTML = ":"+minutos;
}
if (minutos == 59) {
 minutos = -1;
}
if ( (centesimas == 0)&&(segundos == 0)&&(minutos == 0) ) {
 horas ++;
 if (horas < 10) { horas = "0"+horas }
 Horas.innerHTML = horas;
}
document.getElementById("crono").value= horas+":"+minutos+":"+segundos+":"+centesimas;
</script>
<link rel="StyleSheet" href="css/cronometro.css" TYPE="text/css">
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
                            <a href="#" class="navbar-brand">Yuber</a>
                        </div>
                        <! -- Inicia Menu -->
                        <div class="collapse navbar-collapse" id="navegacion-Lm">
                    </div>
                </div>
            </div>
        </nav>
    </header>

	<center>
		<h2>Cuando finalice el servicio darle a Finalizar Servicio</h2>
	</center>
	<div id="contenedor">
	<div class="reloj" id="Horas">00</div>
	 <div class="reloj" id="Minutos">:00</div>
	 <div class="reloj" id="Segundos">:00</div>
	 <div class="reloj" id="Centesimas">:00</div>
	</div>
	<div class="jumbotron">
		<center>
		 	<form method="post" action="FinalizarServicio">
				<input type="hidden" name="tiempo" id="crono">
				<input type="submit" class="btn btn-danger" value="Finalizar Servicio">
		 	</form>
	 	</center>
 	</div>
</body>
</html>