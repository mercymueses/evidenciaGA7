package com.mycompany.software_de_ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class factura {
    public static void main(String[] args) {
       String factura="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/software_de_ventas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, factura, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM factura");
            while(rs.next()){
                System.out.println(rs.getString("id_factura"));
            }
     
           // Insercion de datos
            statement.execute(" INSERT INTO `factura` (`id_factura`, `fecha_de_emisión`, `id_cliente`, `nombre`, `apellido`, `correo_electronico`, `id_producto`, `nombre_producto`, `precio_unitario`, `subtotal`) VALUES ('1209', '2024-11-23', NULL, 'mercy', 'matabanchoy', 'mercy@gmail.com', '2020', 'pantaloneta', '30000', '30000');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM factura");
            while(rs.next()){
                System.out.println(rs.getString("id_factura"));
            }
        
            //Actualización de datos
            statement.execute("  UPDATE `factura` SET `id_cliente` = '34578320' WHERE `factura`.`id_factura` = 1209;  ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM factura");
            while(rs.next()){
                System.out.println(rs.getString("id_factura"));
            }
        
            //borrado o eliminacion de datos
            statement.execute(" DELETE FROM factura WHERE `factura`.`id_factura` = 1209");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM factura");
            while(rs.next()){
                System.out.println(rs.getString("id_factura"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




    

