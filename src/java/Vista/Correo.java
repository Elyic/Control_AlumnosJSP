/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Controlador.Captcha.isCaptchaValid;
import Controlador.MetodosU;
import Modelo.Email;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Byron Catalan
 */
public class Correo extends HttpServlet {

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
            out.println("<title>Servlet Correo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Correo at " + request.getContextPath() + "</h1>");
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
       if(isCaptchaValid("6LflNVwUAAAAALvq5zBUKzgK1xT7bPVsZOl7xTD_", request.getParameter("g-recaptcha-response"))){
            String para = request.getParameter("Email");
       String de = "dontreply.e.ingenieria@gmail.com";
            String clave = "enviacorreo";
            MetodosU mu = new MetodosU();
            if (mu.ConsultarCorreo(para)) {
            String contra = mu.ConsultarContraseña(para);
            String mensaje = "Su clave es:\n\n"+contra;
            String asunto = "Recuperación de clave";
            Email email = new Email();
                if (email.enviarCorreo(de, clave, para, mensaje, asunto)) {
                    try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Correo Enviado!');");
   out.println("location='index.jsp';");
   out.println("</script>");
            }
                }else{
                    try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Ocurrio un error al enviar el correo!');");
   out.println("location='index.jsp';");
   out.println("</script>");
            }
//                }
        }}else{
             try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('El correo ingresado no es valido!!!');");
   out.println("location='index.jsp';");
   out.println("</script>");
            }   
            }
        }else{
          try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('El Captcha ingresado no es valido!!!');");
   out.println("location='Recuperar.jsp';");
   out.println("</script>");
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
