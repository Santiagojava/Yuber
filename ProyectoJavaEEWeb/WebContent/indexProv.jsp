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
        <div class="pedido">
            <a href="pedido.html">0 pedidos nuevos</a>
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