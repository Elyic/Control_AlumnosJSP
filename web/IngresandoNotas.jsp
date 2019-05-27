<%-- 
    Document   : index
    Created on : 26/05/2018, 10:31:32 PM
    Author     : Usuario
--%>

<%@page import="Controlador.MetodoCurso"%>
<%@page import="Modelo.Notas"%>
<%@page import="Controlador.MetodosNota"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Controlador.MetodosU"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="Modelo.Conexion"%>
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
        <title>Ingreso de Notas</title>
    </head>
    <body>
         <main>
       <header>
           <label class="lnr lnr-menu show-menu"></label>
       </header>
        <%@include file="/template/menu.jsp" %>
        <div class="content-section">
            <section>
                
                <form action="IngresoNotas" method="POST">
       <select name="Cursos" class="browser-default multiple">
           <%-- <option value="" disabled selected>Seleccione curso:</option>--%>
             <%    
                        MetodosU mu = new MetodosU();
                        LinkedList<String> lista = mu.ConsultarCursos();
                        for (int i = 0; i < lista.size(); i++) {
                                out.println("<option value='"+lista.get(i)+"'>"+lista.get(i)+"</option>");
                            }
                %> 
       </select>
       <br>
       <center><button type="submit"   class="btn btn-default blue darken-1" id="btnLogin">Mostrar</button></center>
       </form>  
       <br>
               <%-- <h2 id="H2">Listado de Alumnos</h2>
                <table border="1" class="highlight responsive-table striped">
    <tr>
    <td>Nombre</td>
    <td>Parcial I</td>
    <td>Parcial II</td>
    <td>Actividades</td>
    <td>Examen Final</td>
    <td>Nota Final</td>
    </tr>--%>
    <%
        String curso = (String)request.getAttribute("curso");
        if (curso == null) {
               
            }else{
            out.println("<h2 id='H2'>Listado de Alumnos</h2>");
            out.println("<form action='INotas' method='POST'>");
            out.println("<table border='1' class='highlight responsive-table striped'>");
            out.println("<tr>");
            out.println("<td>Nombre</td>");
            out.println("<td>Parcial I</td>");
            out.println("<td>Parcial II</td>");
            out.println("<td>Actividades</td>");
            out.println("<td>Examen Final</td>");
            out.println("<td>Nota Final</td>");
            out.println("</tr>");
            MetodoCurso mc = new MetodoCurso();
            int idc = mc.ConsultarID(curso);
            LinkedList<Notas> listas = MetodosNota.consultar(idc);
            for (int i=0;i<listas.size();i++){
               out.println("<tr>");          
           out.println("<td>"+listas.get(i).getNombre()+" "+listas.get(i).getApellido()+"</td>");
           //out.println("<td>"+listas.get(i).getP1()+"</td>");
           out.println("<td>");
           out.println("<input  id='first_name' type='text' class='validate' size='1' value='"+listas.get(i).getP1()+"' name='P1"+i+"'>");
           out.println("</td>");
           out.println("<td>");
           out.println("<input  id='first_name' type='text' class='validate' size='1' value='"+listas.get(i).getP2()+"' name='P2"+i+"'>");
           out.println("</td>");
           out.println("<td>");
           out.println("<input  id='first_name' type='text' class='validate' size='1' value='"+listas.get(i).getZ()+"' name='Z"+i+"'>");
           out.println("</td>");
           out.println("<td>");
           out.println("<input  id='first_name' type='text' class='validate' size='1' value='"+listas.get(i).getPF()+"' name='PF"+i+"'>");
           out.println("</td>");
           out.println("<td>");
           out.println("<input  id='first_name' type='text' class='validate' size='1' readonly value='"+listas.get(i).getNF()+"' name='NF"+i+"'>");
           out.println("</td>");
           out.println("<td>");
           out.println("<input  id='first_name' style='visibility:hidden' type='text' class='validate' size='1' value='"+listas.get(i).getID()+"' name='ID"+i+"'>");
           out.println("</td>");
           out.println("</tr>"); 
            }
             out.println("</table>");
             out.println("<input  id='first_name' style='visibility:hidden' type='text' class='validate' size='1' value='"+listas.size()+"' name='Cantidad'>");
             if (listas.size()==0) {
                     
                 }else{
                 out.println("<center><button type='submit'   class='btn btn-default blue darken-1' id='btnLogin'>Guardar Cambios</button></center>");
             }
             
             out.println("</form>");
        }
        %>
   <%-- </table>  --%>
             </section>
        </div>
    </main>
    <script src="js/jquery.js"></script>
    <script src="js/script.js"></script>
    </body>
</html>
