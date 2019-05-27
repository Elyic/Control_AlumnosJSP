<%-- 
    Document   : index
    Created on : 26/05/2018, 10:31:32 PM
    Author     : Usuario
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="Controlador.MetodosU"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Modelo.Conexion"%>
<%@page import="java.sql.Connection"%>
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
        
        <title>Asignación de Cursos</title>
    </head>
    <body>
         <main>
       <header>
           <label class="lnr lnr-menu show-menu"></label>
       </header>
        <div class="" style="background-color: transparent;">
            <section>
                
                <form id="form3" action="Curso" method="POST">
                    <img src="img/172.png">
                <h1 id="H2">Asignación de Cursos</h1>
                <div>
                    <%--<center><div class = "row">
               <label>Ingresa tu curso:</label>--%>
                    <%
                        String user = (String)request.getParameter( "usuario");
                        out.println("<input id='last_name'style='visibility:hidden' type='text' value='"+user+"' class='validate' name='alumno'>");
                        %>
               <select name="Cursos">
                 <%-- <option  value = "" disabled selected>Cursos</option> --%>
                  <%    
                        MetodosU mu = new MetodosU();
                        LinkedList<String> lista = mu.ConsultarCursos();
                        for (int i = 0; i < lista.size(); i++) {
                                out.println("<option value='"+lista.get(i)+"'>"+lista.get(i)+"</option>");
                            }
                %> 
</select> 
              <%-- <input id="last_name" type="text" class="validate" name="Cursos"> --%>
               </div></center>
                   
               <center><button type="submit"   class="btn btn-default blue darken-1" id="btnLogin">Asignar Cursos</button></center> 
               <br>
               <%
                   out.println("<center><a href='principalAlumno.jsp?usuario="+user+"' class='btn btn-default blue darken-1' id='btnLogin'>Regresar</a></center>");
                   %>
           
                </div>
                </form>
            </section>
        </div>
    </main>
    </body>
</html>
