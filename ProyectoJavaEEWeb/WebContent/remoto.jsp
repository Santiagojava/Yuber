<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="css/map.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilo.css">
    <title> YUBER - remoto</title>
    <script src="http://maps.googleapis.com/maps/api/js"> </script>    
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="js/main.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
                    <a href="index.php" class="navbar-brand">Yuber</a>
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
        </nav>
    </header>

<div class="jumbotron">
    <ul class="nav nav-tabs nav-justified">
        <li role="presentation"><a href="Transporte.jsp">TRANSPORTE</a></li>
        <li role="presentation" ><a href="on-site.jsp">ON-SITE</a></li>
        <li role="presentation" class="active"><a href="remoto.jsp">REMOTO</a></li>
    </ul>
<div class="info">
<img src="img/zaichina-en-construccion.jpg" width="1000px" height="100%">
    
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
</html>﻿

</body>
</html>