<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilo.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/main.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>YUBER - Servicio</title>
<script>
	$(document).on("mouseenter", "#mouse", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
        $.get("IngresoCliente", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
			if(responseText == "Cronometro.jsp"){
				window.location.replace("Cronometro.jsp");
			}
			else{
				$("#mouse").text(responseText);
			}
                       // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
        });
    });
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
	                    <a href="index.html" class="navbar-brand">Yuber</a>
	                </div>
	        <! -- Inicia Menu -->
	                <div class="collapse navbar-collapse" id="navegacion-Lm">
	                <ul class="nav navbar-nav">
	                    <li><a href="Review.jsp">Historial</a></li>
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
	<div class="jumbotron">
		<center>
			<h2 id="mouse">Espera a que tu solicitud sea aceptada por un Proveedor...</h2>
			<div id="mensaje"></div>
		</center>
	</div>
</body>
</html>