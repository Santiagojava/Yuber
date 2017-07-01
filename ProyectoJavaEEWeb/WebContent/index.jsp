<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<title>Yuber - compartiendo servicios</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
  </head>
</head>


<body>
<%  if(request.getSession().getAttribute("error") != null){ %>
		<div style="color: #FF0000;">${error}</div>
<%  	request.getSession().removeAttribute("error");
	} %>
	<div class="login">	
		<img class="logo" src="img/logoBlk.png">
		<div class="row">
  			<div class="col-lg-2 col-lg-offset-5">
  			<form action="Review" method="GET">
				<input type="text" class="form-control input-sm" placeholder="usuario" name="usu" id="usu">
				<br>
				<input type="password" class="form-control input-sm" placeholder="contraseña" name="psswd" id="psswd">
				<br>
				<button type="submit" class="btn btn-danger">Ingresar</button>
				<br>
				<a href="registro.jsp">Registrate ahora!</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>