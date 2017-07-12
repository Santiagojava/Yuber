<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        <title> YUBER - Inicio</title>   
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/main.js"></script>
        <script src="js/bootstrap.min.js"></script> 
        <!--<script type="text/javascript">
		    $(document).ready(function() {
		    	$('#actualizar').click(function() {
	                //var name = $('#userName').val();
	                $.axaj({
						type:'POST',
						url:'IngresoProveedor',
						success: function(result){
							$('#cantidad').html(result);
						}
	                });
	        	});
		    });
	    </script>-->
	    <script>
		    $(document).on("click", "#actualizar", function() {        // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		        $.get("IngresoProveedor", function(responseJson) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
		            var $table = $("<table>").appendTo($("#cantidad")); // Create HTML <table> element and append it to HTML DOM element with ID "somediv".
		            $.each(responseJson, function(index, solicitud) {    // Iterate over the JSON array.
		                //$("<form method='post'>").appendTo($table)
		                    //.append($("<h2>").text(solicitud.id))        
		                    //.append($("<h2>").text(solicitud.destino))   
		                    //.append($("<h3>").text(solicitud.nombre_cli))
		                    //.append($("<input type='submit' value='Aceptar'>"));
		                	//document.getElementById('').value='new value';
		                
		                $('<form>').attr({
		                    id: 'form1',
		                    name: 'form1',
		                    method:'post',
		                    action: 'VerSolicitud'
		                }).appendTo($table);

		                $('<h3>').attr({
		                    id: solicitud.id
		                }).appendTo('#form1');
		                
		                $('<input>').attr({
		                    type: 'hidden',
		                    id: 'foo',
		                    value : solicitud.nombre_cli,
		                    name: 'nombre_cli'
		                }).appendTo('#form1');

		                $('<input>').attr({
		                    type: 'hidden',
		                    id: 'foo',
		                    value : solicitud.destino,
		                    name: 'ubicacion'
		                }).appendTo('#form1');

		                $('<input>').attr({
		                    type: 'submit',
		                    value : 'Aceptar'
		                }).appendTo('#form1');

		                $('<br>').appendTo('#form1');
		                $('<br>').appendTo('#form1');
		                document.getElementById(solicitud.id).innerHTML = solicitud.nombre_cli;
		            });
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
                        <!-- Inicia Menu -->
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
        <img class="logo" src="img/logoBlk.png" href="index.html" width="100%">
       	<button class="btn btn-primary" id="actualizar">Actualizar Bandeja</button>
       	<br><br>
      		<div id="cantidad"></div>
        <!-- 
        <div class="pedido">
            <a href="pedido.html">0 pedidos nuevos</a>
        </div>
        -->
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