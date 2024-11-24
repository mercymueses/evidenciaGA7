package com.mycompany.software_de_ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente {
    public static void main (String[]args){
        String cliente="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/software_de_ventas" ;
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, cliente, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * USUARIOS cliente");
            while(rs.next()){
                System.out.println(rs.getString("cliente"));
            }
            
            //Insercion de datos
            statement.execute("INSERT INTO `cliente` (`id_cliente`, `nombre`, `dirección`, `correo_electronico`, `telefono`) VALUES ('41181709', 'lucia Rosa', 'barrio/los sauces/sibundoy', 'rosccm@gmail.com', '3145678900');");
            System.out.println();
            rs = statement.executeQuery("SELECT * USUARIOS cliente");
            while(rs.next()){
                System.out.println(rs.getString("id_cliente"));
            }
            
            //Actualización de datos
            statement.execute("UPDATE `cliente` SET `nombre` = 'Diana Yerly' WHERE `cliente`.`id_cliente` = 23472623; ");
             System.out.println();
             rs = statement.executeQuery("SELECT * USUARIOS cliente");
            while(rs.next()){
                System.out.println(rs.getString("id_cliente"));
            }
            
            //borrado o eliminacion de datos
            statement.execute(" DELETE FROM cliente WHERE `cliente`.`id_cliente ");
             System.out.println();
             rs = statement.executeQuery("SELECT * USUARIOS cliente");
            while(rs.next()){
                System.out.println(rs.getString("id_cliente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    

