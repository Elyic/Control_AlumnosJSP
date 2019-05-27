/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.MetodosNota;
import Modelo.Notas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elyic
 */
public class INotas extends HttpServlet {

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
            out.println("<title>Servlet INotas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet INotas at " + request.getContextPath() + "</h1>");
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
        int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
        
        for (int i = 0; i < cantidad; i++) {
            Notas n = new Notas();
        MetodosNota mn = new MetodosNota();
            n.setP1(Integer.parseInt(request.getParameter("P1"+i+"")));
            n.setP2(Integer.parseInt(request.getParameter("P2"+i+"")));
            n.setZ(Integer.parseInt(request.getParameter("Z"+i+"")));
            n.setPF(Integer.parseInt(request.getParameter("PF"+i+"")));
            n.setNF(n.getP1()+n.getP2()+n.getZ()+n.getPF());
            n.setID(Integer.parseInt(request.getParameter("ID"+i+"")));
            mn.IngresoNotas(n);
        }
        try (PrintWriter out = response.getWriter()) {
    out.println("<script type=\"text/javascript\">");
   out.println("alert('Notas ingresadas');");
   out.println("location='IngresandoNotas.jsp';");
   out.println("</script>");
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
