/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mostrar;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMostrar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del procedimiento almacenado: ");
        String procedureName = scanner.nextLine();

        try {
            StoredProcedureMostrar procedure = StoredProcedureFactoryMostrar.getStoredProcedureMostrar(procedureName);
            procedure.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
