package com.mycompany.software_de_ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class categoria {
    public static void main(String[] args) {
       String categoria="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/software_de_ventas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, categoria, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM categoria");
            while(rs.next()){
                System.out.println(rs.getString("nombre_categoria"));
            }
     
           // Insercion de datos
            statement.execute("INSERT INTO `categoria` (`id_categoria`, `nombre_categoria`, `descripción_categoria`) VALUES ('1010', 'belleza', 'todo en bellaza para mujer'), ('234', 'belleza', 'todo en maquillaje para concertir ala mujer');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM categoria");
            while(rs.next()){
                System.out.println(rs.getString("nombre_categoria"));
            }
        
            //Actualización de datos
            statement.execute(" UPDATE `categoria` SET `id_categoria` = '2020', `nombre_categoria` = 'utiles escolares', `descripción_categoria` = 'todo en utiles para comenzar un nuevo año con extito' WHERE `categoria`.`id_categoria` = 1010;  ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM categoria");
            while(rs.next()){
            System.out.println(rs.getString("nombre_categoria"));
            }
        
            //borrado o eliminacion de datos
            statement.execute("\"DELETE FROM categoria WHERE `categoria`.`id_categoria` = 234");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM categoria");
            while(rs.next()){
                System.out.println(rs.getString("nombres_categoria"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



 

