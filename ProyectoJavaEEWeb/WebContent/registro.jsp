<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Yuber - Registro</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
	<style type="text/css">
    .box{
        display: none;
    }
    </style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	    $('input[type="radio"]').click(function(){
	        var inputValue = $(this).attr("value");
	        var targetBox = $("." + inputValue);
	        $(".box").not(targetBox).hide();
	        $(targetBox).show();
	    });
	});
	</script>
	
</head>
<body bgcolor="green">
	<div class="registro">	
	<div class="col-lg-2 col-lg-offset-5" align="center">
		<img class="logo-registro" src="img/logoBlk.png" href="index.html" width="200px" height="100%">
		<div class="row">
			<h3>Registro</h3>
			<label class="radio-inline"><input type="radio" name="optradio" value="a">Cliente</label>
			<label class="radio-inline"><input type="radio" name="optradio" value="red">Proveedor</label>
			<br>
			<div class="red box">
				<label><input type="checkbox" name="optradio" value="a">Transporte<br></label>
				<label><input type="checkbox" name="optradio" value="b">On-site<br></label>
				<label><input type="checkbox" name="optradio" value="c">Remoto<br></label>
				<br>
			</div>
			<input type="text" class="form-control input-sm" placeholder="email">
			<br>
			<input type="text" class="form-control input-sm" placeholder="contraseña">
			<br>
			<input type="text" class="form-control input-sm" placeholder="repetir contraseña">
			<br>
			<input type="text" class="form-control input-sm" placeholder="nombre">
			<br>
			<input type="text" class="form-control input-sm" placeholder="apellido">
			<br>
			<input type="text" class="form-control input-sm" placeholder="telefono">
			<br>
			<input type="password" class="form-control input-sm" placeholder="tarjeta">
			<br>
			<button type="submit" class="btn btn-danger">Registrarse</button>
		</div>
	</div>
	</div>
</body>
</html>