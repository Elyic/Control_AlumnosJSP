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
public class MetodosNota {
    Conexion conexion = new Conexion();
    public boolean Ingreso (int IDA, int IDC)
    {
         
        boolean v = false;
        Connection conecta = conexion.getConexion();
         if (conecta!=null) {
            try {
                String SQL = "insert into Notas(ID_A,ID_C) values(?,?)";
                PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
                preparedStmt.setInt(1, IDA);
                preparedStmt.setInt(2, IDC);
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
    public  boolean  ConsultarCurs(int IDA, int IDC)
{
    Conexion conexion = new Conexion();
        boolean v = false;
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="Select count(1) from Notas where ID_A=? and ID_C=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setInt(1, IDA);
                consulta.setInt(2, IDC);
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
    public static LinkedList<Notas> consultar(int ID)
{
     LinkedList<Notas> usuarios = new LinkedList<Notas>();
     Conexion conexion = new Conexion();
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="Select *from Notas\n" +
"join Cursos on Cursos.ID=Notas.ID_C\n" +
"join Usuarios on Usuarios.ID=Notas.ID_A\n" +
"where ID_C=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setInt(1, ID);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 Notas n = new Notas();
                 n.setNombre(resultado.getString("Nombre"));
                 n.setApellido(resultado.getString("Apellido"));
                 n.setP1(resultado.getInt("P1"));
                 n.setP2(resultado.getInt("P2"));
                 n.setPF(resultado.getInt("PF"));
                 n.setZ(resultado.getInt("Z"));
                 n.setNF(resultado.getInt("NF"));
                 n.setID(resultado.getInt(1));
                 usuarios.add(n);
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
    public boolean IngresoNotas (Notas n)
    {
         
        boolean v = false;
        Connection conecta = conexion.getConexion();
         if (conecta!=null) {
            try {
                String SQL = "UPDATE Notas set P1=?, P2=?, Z=?, PF=?, NF=? where ID=?";
                PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
                preparedStmt.setInt(1, n.getP1());
                preparedStmt.setInt(2, n.getP2());
                preparedStmt.setInt(3, n.getZ());
                preparedStmt.setInt(4, n.getPF());
                preparedStmt.setInt(5, (n.getP1()+n.getP2()+n.getZ()+n.getPF()));
                preparedStmt.setInt(6, n.getID());
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
  public static LinkedList<Notas> consultarNotas(int ID)
{
     LinkedList<Notas> usuarios = new LinkedList<Notas>();
     Conexion conexion = new Conexion();
     Connection conecta = conexion.getConexion();
         if (conecta!=null) {

         try {
             String SQL ="Select *from Notas\n" +
"join Cursos on Cursos.ID=Notas.ID_C\n" +
"join Usuarios on Usuarios.ID=Notas.ID_A\n" +
"where ID_A=?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setInt(1, ID);
                ResultSet resultado = consulta.executeQuery();
             while(resultado.next()){
                 Notas n = new Notas();
                 n.setNombre(resultado.getString("Curso"));
                 n.setP1(resultado.getInt("P1"));
                 n.setP2(resultado.getInt("P2"));
                 n.setPF(resultado.getInt("PF"));
                 n.setZ(resultado.getInt("Z"));
                 n.setNF(resultado.getInt("NF"));
                 n.setID(resultado.getInt(1));
                 usuarios.add(n);
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
}
