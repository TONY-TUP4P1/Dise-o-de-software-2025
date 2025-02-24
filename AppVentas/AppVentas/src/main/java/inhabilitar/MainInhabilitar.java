/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inhabilitar;

import com.mycompany.appventas.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainInhabilitar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del procedimiento almacenado: ");
        String procedureName = scanner.nextLine();

        System.out.print("Introduce el ID: ");
        int id = scanner.nextInt();

        try (Connection connection = DatabaseConnection.getConnection()) {
            StoredProcedureInhabilitar procedure = StoredProcedureFactoryInhabilitar.getStoredProcedureInhabilitar(procedureName, id);
            procedure.execute(connection);
            System.out.println("Procedimiento ejecutado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
