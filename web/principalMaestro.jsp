<%-- 
    Document   : index
    Created on : 26/05/2018, 10:31:32 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
         <link rel="stylesheet" href="css/estilos.css">
          <link rel="stylesheet" href="css/style.css">
         <link rel="stylesheet" href="Icon/style.css">
        <title>Principal</title>
    </head>
    <body>
         <main>
       <header>
           <label class="lnr lnr-menu show-menu"></label>
       </header>
        <%@include file="/template/menu.jsp" %>
        <div class="content-section">
            <section>
                <h2 id="H2">UNIVERSIDAD MARIANO GÁLVEZ DE GUATEMALA</h2>
                <br>
                <center> <div class="slider">
			<ul>
				<li>
                                    <img src="img/Img1.jpg" alt=""/>
                                </li>
				<li>
                                    <img src="img/Img2.png" alt=""/>
                                </li>
                                <li>
                                    <img src="img/img3.jpg" alt=""/>
                                </li>
                                <li>
                                    <img src="img/Img4.jpg" alt=""/>
                                </li>
                        </ul>
                         
                    </div></center>
                
            </section>
        </div>
    </main>
    <script src="js/jquery.js"></script>
    <script src="js/script.js"></script>
    </body>
</html>
