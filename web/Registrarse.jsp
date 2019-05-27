<%-- 
    Document   : Registrarse
    Created on : 21/05/2018, 02:40:42 PM
    Author     : Usuario
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="Controlador.MetodosU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Registrarse</title>
    </head>
    <body bgpbgproperties="fixed">
        <main>
        <div class="row" id="form2">
            <form class="col s12" onsubmit="return prueba()" action="RegistroU" method="POST">
        <h2 id="H2">Registro de Nuevo Usuario</h2>
      <div class="row ">
        <div class="input-field col s6">
          <input  id="first_name" type="text" class="validate" name="Nombre">
          <label for="first_name">Nombres</label>
        </div>
        <div class="input-field col s6">
          <input id="last_name" type="text" class="validate" name="Apellido">
          <label for="last_name">Apellidos</label>
        </div>
      </div>
        
        <label>Género:</label>
    
    <div  id="SlcGenero">
        <p>
      <label>
        <input name="Genero" type="radio" value="Hombre" />
        <span>Hombre</span>
      </label>
    </p>
       
    <p>
      <label> 
        <input name="Genero" type="radio" value="Mujer" />
        <span>Mujer</span>
      </label>
    </p>
    </div>
        
   <label>Tipo de Usuario: </label>
    <div  id="SlcUsu">
        <p>
      <label>
        <input name="Tipo" type="radio" value="Maestro"  />
        <span>Maestro</span>
      </label>
    </p>
       
    <p>
      <label> 
        <input name="Tipo" type="radio" value="Alumno" />
        <span>Alumno</span>
      </label>
    </p>
    </div>
        <div class="row ">
        <div class="input-field col s6">
          <input  id="Usuario" type="text" class="validate" name="Usuario">
          <label for="Usuario">Usuario</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" class="validate" name="Pass">
          <label for="password">Contraseña</label>
        </div>
      </div>
       
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate" name="Email">
          <label for="email">Email</label>
        </div>
      </div>
    <center><button type="submit"   class="btn btn-default blue darken-1" id="btnLogin">Registrarse</button></center>
            </form>
    </div>
        <script type="text/javascript">
            function prueba(){
                if (documente.getElementsByName("Usuario").value=='' || document.getElementsByName("Genero").value=='' || document.getElementById('first_name').value=='' || document.getElementById('last_name').value=='' || document.getElementById('password').value=='' || document.getElementById('email').value=='' || document.getElementById('Usuario').value=='') {
                    alert("Un campo se encuentra vacio");
                    return false;
        }else{
            return true;
        }
            }
        </script>
        
    </body>
</main>
</html>
