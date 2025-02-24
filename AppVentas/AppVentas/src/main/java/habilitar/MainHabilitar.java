/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habilitar;

import com.mycompany.appventas.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainHabilitar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del procedimiento almacenado: ");
        String procedureName = scanner.nextLine();

        System.out.print("Introduce el ID: ");
        int id = scanner.nextInt();

        try (Connection connection = DatabaseConnection.getConnection()) {
            StoredProcedureHabilitar procedure = StoredProcedureFactoryHabilitar.getStoredProcedureHabilitar(procedureName, id);
            procedure.execute(connection);
            System.out.println("Procedimiento ejecutado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
