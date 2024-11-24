package com.mycompany.software_de_ventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pagos {
    public static void main(String[] args) {
       String Pagos="root";
       String password="";
       String url="jdbc:mysql://localhost:3306/software_de_ventas";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, Pagos, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM Pagos");
            while(rs.next()){
                System.out.println(rs.getString("id_nuemro_pago"));
            }
     
           // Insercion de datos
            statement.execute("NSERT INTO `modo de pago` (`id_numero_pago`, `id_cliente`, `metodo-de-pago`, `valor`, `fecha_pago`, `monto_pago`, `estado_pago`, `decripción de costo`) VALUES ('40301', '3456789', 'targeta de credito', '50000', '2024-11-24', '50000', 'en proceso', 'el costo total es de 50000');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM Pagos");
            while(rs.next()){
                System.out.println(rs.getString("id_nuemro_pago"));
            }
        
            //Actualización de datos
            statement.execute(" UPDATE `modo de pago` SET `metodo-de-pago` = 'targeta debito', `estado_pago` = 'pagado' WHERE `modo de pago`.`id_numero_pago` = 40301 ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM Pagos");
            while(rs.next()){
                System.out.println(rs.getString("id_numero_pago"));
            }
        
            //borrado o eliminacion de datos
            statement.execute("DELETE FROM modo de pago WHERE `modo de pago`.`id_numero_pago` = 40301 ");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM Pagos");
            while(rs.next()){
                System.out.println(rs.getString("id_numero_pago"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pagos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

