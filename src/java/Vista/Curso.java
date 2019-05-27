/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.MetodoCurso;
import Controlador.MetodosNota;
import Controlador.MetodosU;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Byron Catalan
 */
@WebServlet(name = "Curso", urlPatterns = {"/Curso"})
public class Curso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Curso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Curso at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {         
           MetodoCurso mc = new MetodoCurso();
           MetodosU mu = new MetodosU();
           MetodosNota mn = new MetodosNota();
           String curso = request.getParameter("Cursos");
           int IDC = mc.ConsultarID(curso);
           String alumno = request.getParameter("alumno");
           int IDA = mu.ConsultarID(alumno);
           if (mn.ConsultarCurs(IDA, IDC)) {
            try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Ya tienes asignado ese curso!');");
   out.println("location='AsignandoCursos.jsp?usuario="+alumno+"';");
   out.println("</script>");
            }
        }else{
             if (mn.Ingreso(IDA, IDC)) {
            try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Curso asignado!');");
   out.println("location='AsignandoCursos.jsp?usuario="+alumno+"';");
   out.println("</script>");
            }
        }else{
               try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Error!!');");
   out.println("location='AsignandoCursos.jsp?usuario="+alumno+"';");
   out.println("</script>");
            }
           }  
           }
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
