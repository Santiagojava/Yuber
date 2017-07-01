<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
	<script src="http://code.jquery.com/jquery-2.0.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<title>Yuber - PayPal</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="panel panel-default"  style="box-shadow: 0px 4px 3px rgba(0,0,0,0.1);">
    <div class="panel-heading">
        <h3 class="panel-title">Pagar con PayPal</h3>
    </div>
<form action="https://www.paypal.com/cgi-bin/webscr" method="post">

  <!-- Identify your business so that you can collect the payments. -->
  <p>Email<input type="text" name="business" placeholder="email"></p>
  

  <!-- Specify a Buy Now button. -->
  <input type="hidden" name="cmd" value="_xclick">

  <!-- Specify details about the item that buyers will purchase. -->
  <p>Servicio<input type="text" class="form-control input-sm" name="item_name" placeholder="servicio"></p>
  <p>Precio<input type="number" class="form-control input-sm" name="amount"placeholder="precio"></p>
  <p><input type="hidden" class="form-control input-sm" name="currency_code" value="USD"></p>

  <!-- Prompt buyers to enter the quantities they want. -->
  <p>Cantidad<input type="number" class="form-control input-sm" name="undefined_quantity"></p>

  <!-- Display the payment button. -->
  <input type="image" name="submit" border="0"
    src="https://www.paypalobjects.com/webstatic/en_US/i/btn/png/btn_buynow_107x26.png"
    alt="Buy Now">
  <img alt="" border="0" width="1" height="1"
    src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >

</form>
</div>
</body>
</html>