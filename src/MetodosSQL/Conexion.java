/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodosSQL;

import com.mysql.jdbc.Connection;
import java.sql.*;


/**
 *
 * @author Latitude E5440
 */
public class Conexion { 
    public static String db="loginbd";
    public static String url="jdbc:mysql://localhost:3306/loginbd";
    public static String usuario="root";
    public static String contrasena="1505";
    public static String clase="com.mysql.jdbc.Driver";
 
    
    public static Connection conectar(){
        Connection conexion= null;
       
        try{
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url,usuario,contrasena);
            
            System.out.println("conexion establecida...");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Nop");
        }
        return conexion;
    }
    
    public static void main(String[] args) {
   Conexion.conectar();
    }
    

}


