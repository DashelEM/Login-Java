/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetodosSQL;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
/**
 *
 * @author Latitude E5440
 */
public class Metodos extends Conexion {  
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;

    public static void guardar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void buscarUserRegistrado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
public int guardar(String nom, String ape, String email, String pass, String phone,String age,String usuario){
    int result = 0;
    Connection cx;
      
    
    
    String sentencia_guardar = ("INSERT INTO usuarios (Nombre, Apellido, Edad, Telefono,Usuario,Contrasena,Email) VALUES(?,?,?,?,?,?,?)");
    try{
        cx = Conexion.conectar();
        sentencia_preparada = (PreparedStatement) cx.prepareStatement(sentencia_guardar);
        sentencia_preparada.setString(1, nom);
        sentencia_preparada.setString(2, ape);
        sentencia_preparada.setString(3, age);
        sentencia_preparada.setString(4, phone);
        sentencia_preparada.setString(5, usuario);
        sentencia_preparada.setString(6, pass);
        sentencia_preparada.setString(7, email);
        
        result = sentencia_preparada.executeUpdate();
        sentencia_preparada.close();
    }catch(SQLException e){
        System.out.println(e);
        
    }
        return 0;
}

public static String buscarNombre(String nom,String ape){
    String busqueda_Nombre=null;

    Connection conexion = null;
    
    try{
     conexion = Conexion.conectar();
     String sentencia_buscar = ("SELECT Nombre,Apellido FROM Usuarios WHERE Nombre = '"+ nom +"' Apellido='"+ape+"'");
     sentencia_preparada= (PreparedStatement) conexion.prepareStatement(sentencia_buscar);
     resultado = sentencia_preparada.executeQuery();
     
     if (resultado.next()){
         String n = resultado.getString("Nombre");
         String a = resultado.getString("Apellido");
         busqueda_Nombre = (n+" "+a);
     }
     
     conexion.close();
     
    }catch(SQLException e){
    System.out.println(e);
    }
        return busqueda_Nombre;
    
    
    
}

public static String buscarUserRegistrado(String user, String pass){
    String busqueda_usuario = null;
    Connection conexion = null;
try{
conexion = Conexion.conectar();
String sentencia_buscar_usuario;
 sentencia_buscar_usuario = ("SELECT Usuario, Contrasena FROM usuarios WHERE Usuario='"+user+"' Contrasena='"+pass+"'");
sentencia_preparada = (PreparedStatement) conexion.prepareStatement(sentencia_buscar_usuario);
resultado = sentencia_preparada.executeQuery();
if(resultado.next()){
    busqueda_usuario = "Usuario registrado.";
}else{
    busqueda_usuario = "Usuario no registrado";
}
conexion.close();
    }catch(SQLException e){
        System.out.println(e);
        }
        return busqueda_usuario;
}


}