package com.mycompany.software_de_ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class compras {
    public static void main(String[] args) {
       String compras="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/software_de_ventas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url,compras, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM compras");
            while(rs.next()){
                System.out.println(rs.getString("id_carrito_compras"));
            }
     
           // Insercion de datos
            statement.execute("INSERT INTO `carrito de compras` (`id_carrito_compras`, `id_cliente`, `nombre`, `id_categoria`, `id_producto`, `cantidad`, `costo`, `subtotal`, `total`, `fecha_compra`) VALUES ('3078', '97472620', 'victor alfonso', '3450', '3456', '1', '40000', '4000', '4000', '2024-11-23');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM compras");
            while(rs.next()){
                System.out.println(rs.getString("id_carrito_compras"));
            }
        
            //Actualización de datos
            statement.execute("UPDATE `carrito de compras` SET `nombre` = 'daniel alfonso' WHERE `carrito de compras`.`id_carrito_compras` = 3078; ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM compras");
            while(rs.next()){
                System.out.println(rs.getString("id_carrito_compras"));
            }
        
            //borrado o eliminacion de datos
            statement.execute("DELETE FROM carrito de compras WHERE `carrito de compras`.`id_carrito_compras` = 3078\"");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM compras");
            while(rs.next()){
                System.out.println(rs.getString("id_carrito_compras"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}





