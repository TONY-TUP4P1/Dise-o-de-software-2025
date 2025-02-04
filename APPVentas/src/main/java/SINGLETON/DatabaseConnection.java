/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SINGLETON;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Instancia única de la clase
    private static DatabaseConnection instance;
    // Conexión a la base de datos
    private Connection connection;

    // URL de la base de datos
    private static final String URL = "jdbc:sqlite:tu_basededatos.db";

    // Constructor privado para evitar instanciación
    private DatabaseConnection() {
        try {
            // Conexión a la base de datos
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la instancia única
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}

