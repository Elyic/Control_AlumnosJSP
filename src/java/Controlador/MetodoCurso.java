/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class MetodoCurso {
    Conexion conexion = new Conexion();
    public boolean IngresoCurso (String curso)
    {
         
        boolean v = false;
        Connection conecta = conexion.getConexion();
         if (conecta!=null) {
            try {
                String SQL = "insert into Cursos(Curso) values(?)";
                PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
                preparedStmt.setString(1, curso);
                preparedStmt.execute();
                v = true;
            } catch (SQLException ex) {
                Logger.getLogger(MetodosU.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    conecta.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MetodosU.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         }
         return v;
}
    public  int  ConsultarID(String curso)
{
    Conexion conexion = new Conexion();
        int v = 0;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="Select (ID) from Cursos where Curso=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, curso);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 v = resultado.getInt("ID");
             }
             resultado.close();
             consulta.close();
             conecta.close();
         } catch (SQLException ex) {
             Logger.getLogger(MetodosU.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             try {
                 conecta.close();
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosU.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
             
         }
         return v;
}
    public  boolean  Verificar(String curso)
{
    Conexion conexion = new Conexion();
        boolean v = false;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select count(1) from Cursos where Curso=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, curso);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 v = resultado.getInt(1)>0;
             }
             resultado.close();
             consulta.close();
             conecta.close();
         } catch (SQLException ex) {
             Logger.getLogger(MetodosU.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             try {
                 conecta.close();
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosU.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
             
         }
         return v;
}
}
