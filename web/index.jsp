<%-- 
    Document   : index
    Created on : 21/05/2018, 12:20:52 PM
    Author     : Usuario
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

        <title>Login</title>
    </head>
    <body bgpbgproperties="fixed">
        
        <div class="container well" id="containerLogin">
        <div class="text-center">
            <img src="img/area_privada.png" class="rounded" alt="...">
        </div>
            
        <form id="form1" onsubmit="return comprobar()" action="Login" method="POST" >
        <div class="form-group row">
            <div class="col-sm-10">
             <input type="text"  class="form-control" id="staticEmail" placeholder=" Usuario" name="Usuario">
            </div>
        </div>
            
        <div class="form-group row">
            <div class="col-sm-10">
              <input type="password" class="form-control  white" id="inputPassword" placeholder=" Contraseña" name="Pass">
            </div>
        </div>
            
        <br>
        <a href="Recuperar.jsp">Recuperar contraseña</a>
  
        <br>
        <center> <a href="Registrarse.jsp" class="btn btn-default blue darken-1" id="btnLogin">Registrarse</a></center>  
        <br>
        <center><button type="submit" class="btn btn-default blue darken-1" id="btnLogin">Ingresar</button></center>
        </form>
        </div>
        <script type="text/javascript">
            function comprobar(){
            if (document.getElementById("staticEmail").value=='' || document.getElementsByID("inputPassword").value=='') {
                alert("Un campo se encuentra vacio!");
                return false;
                    }else{
                return true;}
                }
        </script>
    </body>
</html>
