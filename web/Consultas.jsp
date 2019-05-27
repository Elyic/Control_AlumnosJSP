<%-- 
    Document   : Consultas
    Created on : 6/06/2018, 11:15:14 AM
    Author     : Byron Catalan
--%>

<%@page import="Modelo.Notas"%>
<%@page import="Controlador.MetodosNota"%>
<%@page import="Controlador.MetodosNota"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.LinkedList"%>
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
        <title>Consultas</title>
    </head>
    <body>
       <main>
       <header>
           <label class="lnr lnr-menu show-menu"></label>
       </header>
        <%@include file="/template/menu.jsp" %>
        <div class="content-section">
            <section>
                
                <form action="Consultas" method="POST">
       <select name="Alumno" class="browser-default multiple">
           <%-- <option value="" disabled selected>Seleccione curso:</option>--%>
             <%    
                        MetodosU mu = new MetodosU();
                        LinkedList<Usuario> lista = mu.consultarAlumnos();
                        for (int i = 0; i < lista.size(); i++) {
                                out.println("<option value='"+lista.get(i).getUsuario()+"'>"+lista.get(i).getNombre()+" "+lista.get(i).getApellido()+"</option>");
                            }
                %> 
       </select>
       <br>
       <center><button type="submit"   class="btn btn-default blue darken-1" id="btnLogin">Mostrar</button></center>
       </form>  
       <br>
       <%
           String alumno = (String)request.getAttribute("alumno");
           if (alumno == null) {
                   
               }else{
               int ID = mu.ConsultarID(alumno);
               LinkedList<Notas> listas = MetodosNota.consultarNotas(ID);
               String nombre = mu.ConsultarNombre(alumno);
               String apellido = mu.ConsultarApellido(alumno);
               out.println("<h2 id='H2'>Consulta de Notas</h2>");
               out.println("<h3 id='H2'>Alumno: "+nombre+" "+apellido+"</h3>");
               out.println("<table border='1' class='highlight responsive-table striped'>");
               out.println("<tr>");
               out.println("<td>Curso</td>");
               out.println("<td>Parcial I</td>");
               out.println("<td>Parcial II</td>");
               out.println("<td>Actividades</td>");
               out.println("<td>Examen Final</td>");
               out.println("<td>Nota Final</td>");
               out.println("</tr>");
        for (int i = 0; i < listas.size(); i++) {
        out.println("<td>"+listas.get(i).getNombre()+"</td>");
        out.println("<td>"+listas.get(i).getP1()+"</td>");
        out.println("<td>"+listas.get(i).getP2()+"</td>");
        out.println("<td>"+listas.get(i).getZ()+"</td>");
        out.println("<td>"+listas.get(i).getPF()+"</td>");
        out.println("<td>"+listas.get(i).getNF()+"</td>");
        out.println("</tr>");
        }
        out.println("</table>");
        out.println("<form action='PDFNotasA'>");
        out.println("<input  id='first_name' style='visibility:hidden' type='text' class='validate' size='1' value='"+alumno+"' name='Usuario'>");
        out.println("<center><button type='submit'   class='btn btn-default blue darken-1' id='btnLogin'>Exportar a PDF</button></center>");
        out.println("</form>");
           }
           %>
             </section>
        </div>
    </main>
    <script src="js/jquery.js"></script>
    <script src="js/script.js"></script>
    </body>
</html>
