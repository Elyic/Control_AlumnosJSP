/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.MetodosU;
import Modelo.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Byron Catalan
 */
public class PDFNotasA extends HttpServlet {

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
        String usuario = request.getParameter("Usuario");
        MetodosU mu = new MetodosU();
        int ID = mu.ConsultarID(usuario);
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        Conexion conexion = new Conexion();
        
        try {

            try{
            
            Document documento = new Document(PageSize.LETTER.rotate());
            PdfWriter.getInstance(documento, out);
            
            documento.open();
            
            Paragraph p1 = new Paragraph();          
//            <<CODIGO PARA AGREGAR IMAGEN SI SE NECESITA, SOLO ES DE CAMBIAR LA URL, EL TAMANIO SE DEFINE EN image.scaleToFit
            String url = System.getProperty("user.dir");
            Image imagenes = Image.getInstance("C:\\Users\\Byron Catalan\\Documents\\NetBeansProjects\\ProyectoFinal2\\web\\img\\x.jpeg");
            imagenes.setAlignment(Element.ALIGN_CENTER);
            imagenes.scaleToFit(100, 100);
            p1.add(new Phrase(Chunk.NEWLINE));
            documento.add(imagenes);

            Font fonT= new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLUE);
            p1.add(new Phrase("Notas",fonT));
            p1.setAlignment(Element.ALIGN_CENTER);
            p1.add(new Phrase(Chunk.NEWLINE));
            p1.add(new Phrase(Chunk.NEWLINE));
            p1.add(new Phrase(Chunk.NEWLINE));
            documento.add(p1);

            
            PdfPTable tabla = new PdfPTable(6);
            PdfPCell celda1 = new PdfPCell(new Paragraph("Curso",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));       
            PdfPCell celda2 = new PdfPCell(new Paragraph("Parcial I",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("Parcial II",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("Zona",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("Examen Final",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("Nota Final",FontFactory.getFont("Arial",12,Font.BOLD, BaseColor.BLUE)));
            
            celda1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            celda2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            celda3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            celda4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            celda5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            celda6.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);
            Connection conecta = conexion.getConexion();
            Statement st=null;
            ResultSet rs=null;
            st=(Statement) conecta.createStatement();
            rs= st.executeQuery("Select *from Notas\n" +
"join Cursos on Cursos.ID=Notas.ID_C\n" +
"join Usuarios on Usuarios.ID=Notas.ID_A\n" +
"where ID_A="+ID+"");
            int numero = 0;
            if (conecta!=null){
                while(rs.next()){
                    
                tabla.addCell(rs.getString("Curso"));
                 tabla.addCell(Integer.toString(rs.getInt("P1")));
                 tabla.addCell(Integer.toString(rs.getInt("P2")));
                  tabla.addCell(Integer.toString(rs.getInt("Z")));
                 tabla.addCell(Integer.toString(rs.getInt("PF")));
                 int x=rs.getInt("NF");
                    if (x>=61) {
                   tabla.addCell(Integer.toString(rs.getInt("NF")));     
                    }else{
                tabla.addCell(new Paragraph(Integer.toString(rs.getInt("NF")),FontFactory.getFont("Arial",12, BaseColor.RED)));
                    }numero++;
                 
                }
            }else{
                tabla.addCell("ERROR");
                tabla.addCell("ERROR");
                tabla.addCell("ERROR");
                tabla.addCell("ERROR");
                tabla.addCell("ERROR");
                tabla.addCell("ERROR");
            }
            conecta.close();
            
            documento.add(tabla);
            
            Paragraph p2 = new Paragraph();
            p2.add(new Phrase(Chunk.NEWLINE));
            p2.add(new Phrase("Numeros de cursos asignados: "+numero+"",fonT));
            p2.setAlignment(Element.ALIGN_CENTER);
            documento.add(p2);

            
            documento.close();
            
            
            }catch (Exception ex) {
                ex.getMessage();
                
            }
            
        } finally {
            out.close();
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
