/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.MetodosU;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Byron Catalan
 */
public class RegistroU extends HttpServlet {

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
            out.println("<title>Servlet RegistroU</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistroU at " + request.getContextPath() + "</h1>");
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
        Usuario u = new Usuario();
        u.setNombre(request.getParameter("Nombre"));
        u.setApellido(request.getParameter("Apellido"));
        u.setGenero(request.getParameter("Genero"));
        u.setTipo(request.getParameter("Tipo"));
        u.setUsuario(request.getParameter("Usuario"));
        u.setEmail(request.getParameter("Email"));
        u.setContraseña(request.getParameter("Pass"));
        MetodosU mu = new MetodosU();
        if (mu.ConsultarUsuario(u.getUsuario()) || mu.ConsultarCorreo(u.getEmail()) ) {
                           try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Usuario y/o Email ya en uso!');");
   out.println("location='Registrarse.jsp';");
   out.println("</script>");
            }            
        }else{
              if (mu.IngresoPersona(u)) {
            try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Usuario creado con exito');");
   out.println("location='index.jsp';");
   out.println("</script>");
        }         
        }else{
            try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Ocurrio un error al crear el usuario!');");
   out.println("location='index.jsp';");
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
