/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Notas;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elyic
 */
public class MetodosU {
    Conexion conexion = new Conexion();
    public boolean IngresoPersona (Usuario u)
    {
         
        boolean v = false;
        Connection conecta = conexion.getConexion();
         if (conecta!=null) {
            try {
                String SQL = "insert into Usuarios(Nombre,Apellido,Genero,Tipo,Usuario,Correo,Contraseña) values(?,?,?,?,?,?,?)";
                PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
                preparedStmt.setString(1, u.getNombre());
                preparedStmt.setString(2, u.getApellido());
                preparedStmt.setString(3, u.getGenero());
                preparedStmt.setString(4, u.getTipo());
                preparedStmt.setString(5, u.getUsuario());
                preparedStmt.setString(6, u.getEmail());
                preparedStmt.setString(7, u.getContraseña());
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
    public  boolean  ConsultarUsuario(String Usuario)
{
    Conexion conexion = new Conexion();
        boolean v = false;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select count(1) from Usuarios where Usuario=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, Usuario);
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
    public  boolean  ConsultarCorreo(String Correo)
{
    Conexion conexion = new Conexion();
        boolean v = false;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select count(1) from Usuarios where Correo=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, Correo);
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
    public  boolean  Login(Usuario u)
{
    Conexion conexion = new Conexion();
        boolean v = false;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select count(1) from Usuarios where Contraseña=? and Usuario=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, u.getContraseña());
                consulta.setString(2, u.getUsuario());
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
    public  String  ConsultarTipo(String u)
{
    Conexion conexion = new Conexion();
        String v = null;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select * from Usuarios where Usuario=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, u);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 v = resultado.getString("Tipo");
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
    public  LinkedList<String>  ConsultarCursos()
{
    Conexion conexion = new Conexion();
        LinkedList<String> cursos = new LinkedList<String>();
        String c = null;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select *from Cursos";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 c = resultado.getString("Curso");
                 cursos.add(c);
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
         return cursos;
}
    public  String  ConsultarContraseña(String Correo)
{
    Conexion conexion = new Conexion();
        String contra = null;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select *from Usuarios where Correo=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, Correo);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 contra = resultado.getString("Contraseña");
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
         return contra;
}
    public  int  ConsultarID(String Usuario)
{
    Conexion conexion = new Conexion();
        int v = 0;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="Select (ID) from Usuarios where Usuario=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, Usuario);
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
  public static LinkedList<Usuario> consultarAlumnos()
{
     LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
     Conexion conexion = new Conexion();
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select *from Usuarios where Tipo = 'Alumno'";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 Usuario u = new Usuario();
                 u.setNombre(resultado.getString("Nombre"));
                 u.setApellido(resultado.getString("Apellido"));
                 u.setGenero(resultado.getString("Genero"));
                 u.setUsuario(resultado.getString("Usuario"));
                 u.setEmail(resultado.getString("Correo"));
                 usuarios.add(u);
             }
             resultado.close();
             consulta.close();
             conecta.close();
         } catch (SQLException ex) {
             Logger.getLogger(MetodosNota.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             try {
                 conecta.close();
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosNota.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
             
         }
         return usuarios;
}    
  public  String  ConsultarNombre(String u)
{
    Conexion conexion = new Conexion();
        String v = null;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select * from Usuarios where Usuario=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, u);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 v = resultado.getString("Nombre");
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
  public  String  ConsultarApellido(String u)
{
    Conexion conexion = new Conexion();
        String v = null;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="select * from Usuarios where Usuario=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, u);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 v = resultado.getString("Apellido");
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
