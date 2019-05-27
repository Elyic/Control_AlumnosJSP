<%-- 
    Document   : CrearCurso
    Created on : 5/06/2018, 11:23:50 PM
    Author     : Byron Catalan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
         <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
         <link href="css/style.css" rel="stylesheet" type="text/css"/>
          <link rel = "stylesheet"
         href = "https://fonts.googleapis.com/icon?family=Material+Icons">
      <link rel = "stylesheet"
         href = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
      <script type = "text/javascript"
         src = "https://code.jquery.com/jquery-2.1.1.min.js"></script>           
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js">
      </script> 
      
      <script>
         $(document).ready(function() {
            $('select').material_select();
         });
      </script>
        
        <title>Creacion de Cursos</title>
    </head>
    <body>
       <main>
       <header>
           <label class="lnr lnr-menu show-menu"></label>
       </header>
        <div class="" style="background-color: transparent;">
            <section>
                
                <form id="form3" action="NuevoCurso" method="POST">
                    <img src="img/172.png">
                <h1 id="H2">Ingreso de Cursos</h1>
                <div>
                    <center><div class = "row">
               <label>Ingresa nuevo curso:</label> 
               <input id="last_name" type="text" class="validate" name="Cursos"> 
               </div></center>
                   
               <center><button type="submit"   class="btn btn-default blue darken-1" id="btnLogin">Ingresar</button></center> 
               <br>
              <center><a href="principalMaestro.jsp" class="btn btn-default blue darken-1" id="btnLogin">Regresar</a></center>
                </div>
                </form>
            </section>
        </div>
    </main>
    </body>
</html>
