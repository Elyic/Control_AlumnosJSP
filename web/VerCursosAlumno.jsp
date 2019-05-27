<%-- 
    Document   : VerCursosAlumno
    Created on : 5/06/2018, 11:54:27 PM
    Author     : Byron Catalan
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="Modelo.Notas"%>
<%@page import="Controlador.MetodosNota"%>
<%@page import="Controlador.MetodosU"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Patua+One" rel="stylesheet">
         <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
         <link rel="stylesheet" href="css/estilos.css">
         <link rel="stylesheet" href="css/style.css">
         <link rel="stylesheet" href="Icon/style.css">
        <title>Notas</title>
    </head>
    <body>
        <main>
       <header>
           <label class="lnr lnr-menu show-menu"></label>
       </header>
        <%@include file="/template/menuAlumno.jsp" %>
        <div class="content-section">
            <section> 
       <br>
                <h2 id="H2">Consulta de Notas</h2>
                <table border="1" class="highlight responsive-table striped">
    <tr>
    <td>Curso</td>
    <td>Parcial I</td>
    <td>Parcial II</td>
    <td>Actividades</td>
    <td>Examen Final</td>
    <td>Nota Final</td>
    </tr>
    <%
        String user = (String)request.getParameter( "usuario");
        MetodosU mu = new MetodosU();
        int ID = mu.ConsultarID(user);
        LinkedList<Notas> listas = MetodosNota.consultarNotas(ID);
        for (int i = 0; i < listas.size(); i++) {
        out.println("<td>"+listas.get(i).getNombre()+"</td>");
        out.println("<td>"+listas.get(i).getP1()+"</td>");
        out.println("<td>"+listas.get(i).getP2()+"</td>");
        out.println("<td>"+listas.get(i).getZ()+"</td>");
        out.println("<td>"+listas.get(i).getPF()+"</td>");
        out.println("<td>"+listas.get(i).getNF()+"</td>");
        out.println("</tr>");
            }
        
        %>
    </table> 
             </section>
        </div>
    </main>
    <script src="js/jquery.js"></script>
    <script src="js/script.js"></script>
    </body>
</html>
