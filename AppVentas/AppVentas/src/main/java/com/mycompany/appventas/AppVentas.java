/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appventas;

import java.sql.Connection;
import java.sql.SQLException;

public class AppVentas {
    public static void main(String[] args) {
        try {
            Connection conexion = DatabaseConnection.getConnection();
            if (conexion != null) {
                System.out.println("Se conectó correctamente a la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos, error: " + e.toString());
        }
    }
}
