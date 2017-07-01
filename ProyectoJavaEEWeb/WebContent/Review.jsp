<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/map.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilo.css">
    <title> YUBER - review clientes</title>
    <script src="http://maps.googleapis.com/maps/api/js"> </script>    
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/main.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
    <section class="jumbotron2">
        <div class="modal fade" id="ModalMas" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button>
                        <h4 class="modal-title" id="myModalLabel">Historial
				<span class="glyphicon glyphicon-list-alt"></span></h4>
                    </div>
	            	<form action="Registro" method="GET" name="Fregistro">
                        <div class="modal-body">
                       		<h4>Seleccione el servicio:</h4>
                       		<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    Action <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
								    <li><a href="#">Action</a></li>
								    <li role="separator" class="divider"></li>
								    <li><a href="#">Another action</a></li>
								    <li role="separator" class="divider"></li>
								    <li><a href="#">Something else here</a></li>
								    <li role="separator" class="divider"></li>
								    <li><a href="#">Separated link</a></li>
								</ul>
							</div>
                        </div>
                        <div class="modal-footer">
                          	<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            <button name="aceptar" type="submit" class="btn btn-primary">Aceptar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>                
    </section>
<body bgcolor="green">
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
        <div class="jumbotron">
	<div class="history">	
		<div class="row">
  			<div class="col-lg-2 col-lg-offset-5" align="center">
				<h1>REVIEW</h1>
				<br>
				<br>
				<h3>review propio</h3>
				<h3>review proveedor</h3>
				<h3>comentario propio</h3>
				<h3>comentario proveedor</h3>
				<h3>DD/MM/AAAA hh:mm</h3>
				<h3>nombre del servicio</h3>
				<br>
				<button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#ModalMas">ver mas</button>
			</div>
		</div>
	</div>
	</div>
</body>
</html>