
package Modelo;

import java.sql.*;

public class Conexion 
{
 private Connection con = null;
 public static Statement st = null;
 public static ResultSet rt = null;
 public static Connection conec = null;
 
 public Conexion() {
  String bd = "Proyecto";
        String user= "sa";
        String pass = "123";
        try{
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String bdconect ="jdbc:sqlserver://localhost:1433;databaseName="+bd+";user="+user+";password="+pass+";";
        con = DriverManager.getConnection(bdconect);  
        }catch(ClassNotFoundException e){
            System.out.println("Error: "+e);
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
 }
 
 public Connection getConexion(){
  return con;
 }
 
 public void cerrarConexion(){
  try {
   con.close();
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }
}