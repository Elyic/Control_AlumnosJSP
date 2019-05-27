
<div class="content-menu">
           <div class="content-item">
               <%
                   
                String usuario = (String)request.getAttribute("Usuario");
                if (usuario == null) {
                        usuario = request.getParameter("usuario");
                    }
               out.println("<li ><a href='principalAlumno.jsp?usuario="+usuario+"' style='text-decoration:none'><span class='lnr lnr-home'></span><h4 class='txt1'>Inicio</h4></a></li>");
               out.println("<li ><a href='AsignandoCursos.jsp?usuario="+usuario+"' style='text-decoration:none'><span class='lnr lnr-license'></span><h4 class='txt1'>Asignar Cursos</h4></a></li>");
               out.println("<li><a href='VerCursosAlumno.jsp?usuario="+usuario+"' style='text-decoration:none'><span class='lnr lnr-graduation-hat'></span><h4 class='txt4'>Ver Notas</h4></a></li>");
               out.println("<li><a href='Imprimir.jsp?usuario="+usuario+"' style='text-decoration:none'><span class='lnr lnr-printer'></span><h4 class='txt5'>Imprimir</h4></a></li>");
               %>              
               
               
                <li><a href="index.jsp"  style="text-decoration:none"><span class="lnr lnr-cross"></span><h4 class="txt6">Salir</h4></a></li>
            </div>
</div>
        