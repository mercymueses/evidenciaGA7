package com.mycompany.software_de_ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class producto {
    public static void main(String[] args) {
       String producto="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/software_de_ventas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, producto, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM producto");
            while(rs.next()){
                System.out.println(rs.getString("nombres"));
            }
     
           // Insercion de datos
            statement.execute(" INSERT INTO `producto` (`id_producto`, `nombre`, `descripción`, `valor`, `cantidad`, `id_categoria`) VALUES ('00041', 'pantaloneta de algodon organico color negro', 'pantaloneta corta comada para hacer ejercicio.', '300000', '4', '101');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM producto");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        
            //Actualización de datos
            statement.execute("UPDATE `producto` SET `nombre` = 'pantalon de algodon organico, color azul marino', `descripción` = 'pantalon ,100% algodon organico, suave y comodo. ideal para uso diario. ' WHERE `producto`.`id_producto` = 12345; ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM producto");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        
            //borrado o eliminacion de datos
            statement.execute(" DELETE FROM producto WHERE `producto`.`id_producto");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM producto");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}






