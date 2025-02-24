/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appventas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String USUARIO = "UserSQLMaster";
    private static final String CONTRASENIA = "master";
    private static final String BD = "AppVentas";
    private static final String IP = "localhost";
    private static final String PUERTO = "1433";

    public static Connection getConnection() throws SQLException {
        String cadena = "jdbc:sqlserver://" + IP + ":" + PUERTO + ";databaseName=" + BD + ";Trusted_Connection=false;MultipleActiveResultSets=true;TrustServerCertificate=true";
        return DriverManager.getConnection(cadena, USUARIO, CONTRASENIA);
    }
}
        
        