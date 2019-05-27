<%-- 
    Document   : Imprimir
    Created on : 6/06/2018, 12:10:20 PM
    Author     : Byron Catalan
--%>

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
        <title>Imprimir</title>
    </head>
    <body>
        <main>
       <header>
           <label class="lnr lnr-menu show-menu"></label>
       </header>
        <%@include file="/template/menuAlumno.jsp" %>
        <div class="content-section">
            <section>
                
                <form action="PDFNotasA" >
                    <%
                        String user = (String)request.getParameter( "usuario");
                    out.println("<input  id='first_name' style='visibility:hidden' type='text' class='validate' size='1' value='"+user+"' name='Usuario'>");
       %>
                    <br>
       <center><button type="submit"   class="btn btn-default blue darken-1" id="btnLogin">Exportar a PDF</button></center>
       </form>  
       <br>
             </section>
        </div>
    </main>
    <script src="js/jquery.js"></script>
    <script src="js/script.js"></script>
    </body>
</html>
