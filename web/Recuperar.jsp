<%-- 
    Document   : Recuperar
    Created on : 29/05/2018, 03:12:31 PM
    Author     : Elyic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src='https://www.google.com/recaptcha/api.js'></script>
        <title>Recuperar Contraseña</title>
    </head>
    <body bgpbgproperties="fixed">
        <div class="container well" id="containerLogin">
            <form id="form1"  action="Correo" method="POST" >
  <div class="form-group row">
    <div class="col-sm-10">
      <input type="text"  class="form-control" id="staticEmail" placeholder=" Email" name="Email">
    </div>
  </div>
       <div  class="g-recaptcha" data-sitekey="6LflNVwUAAAAADRD0Rz97LGJIQvEhKlgW1uSLfoE"></div>     
   <br>
   <center> <a href="index.jsp" class="btn btn-default blue darken-1" id="btnLogin">Regresar</a></center>  
<br>
<center><button type="submit" class="btn btn-default blue darken-1" id="btnLogin">Recuperar</button></center>
                   </form>
        </div>
    </body>
</html>
