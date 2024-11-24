package com.mycompany.software_de_ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Software_de_ventas {
    public static void main(String[] args) {
       String administrador_tienda_virtual="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/software_de_ventas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, administrador_tienda_virtual, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM administrador_tienda_virtual");
            while(rs.next()){
                System.out.println(rs.getString("nombres"));
            }
     
           // Insercion de datos
            statement.execute("INSERT INTO `administrador_tienda_virtual` (`id_administrador_tienda_virtual`, `nombres`, `apellidos`, `telefono`, `correo_electronico`, `lugar_de_recidencia`) VALUES ('10104567', 'Samuel Eduardo', 'Yama Mueses', '3156823164', 'samuely@gmail.com', 'Orito');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM administrador_tienda_virtual");
            while(rs.next()){
                System.out.println(rs.getString("nombres"));
            }
        
            //Actualización de datos
            statement.execute("UPDATE `administrador_tienda_virtual` SET `id_administrador_tienda_virtual` = '974726365', `nombres` = 'Lucas Mateo', `apellidos` = 'Rodriges Mora', `telefono` = '3156580027', `correo_electronico` = 'lucasmateo@gmail.com' WHERE `administrador_tienda_virtual`.`id_administrador_tienda_virtual` = 974726322; ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM administrador_tienda_virtual");
            while(rs.next()){
                System.out.println(rs.getString("nombres"));
            }
        
            //borrado o eliminacion de datos
            statement.execute("DELETE FROM administrador_tienda_virtual WHERE `administrador_tienda_virtual`.`id_administrador_tienda_virtual` = 974726365 ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM administrador_tienda_virtual");
            while(rs.next()){
                System.out.println(rs.getString("nombres"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Software_de_ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



