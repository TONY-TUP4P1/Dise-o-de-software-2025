/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import com.mycompany.appventas.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class MainActualizar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del procedimiento almacenado: ");
        String procedureName = scanner.nextLine();

        Object[] parametros = null;

        switch (procedureName) {
            case "ActualizarCategoriaProducto":
                parametros = new Object[2];
                System.out.print("Introduce el ID de la categoría: ");
                parametros[0] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Introduce el nombre: ");
                parametros[1] = scanner.nextLine();
                break;
            case "ActualizarProducto":
                parametros = new Object[7];
                System.out.print("Introduce el ID del producto: ");
                parametros[0] = scanner.nextInt();
                System.out.print("Introduce el stock: ");
                parametros[1] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Introduce el nombre: ");
                parametros[2] = scanner.nextLine();
                System.out.print("Introduce el lugar de procedencia: ");
                parametros[3] = scanner.nextLine();
                System.out.print("Introduce la unidad de medida: ");
                parametros[4] = scanner.nextLine();
                System.out.print("Introduce el precio: ");
                parametros[5] = scanner.nextDouble();
                System.out.print("Introduce el ID de la categoría del producto: ");
                parametros[6] = scanner.nextInt();
                break;
            case "ActualizarCliente":
                parametros = new Object[7];
                System.out.print("Introduce el ID del cliente: ");
                parametros[0] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Introduce la dirección: ");
                parametros[1] = scanner.nextLine();
                System.out.print("Introduce el teléfono: ");
                parametros[2] = scanner.nextLine();
                System.out.print("Introduce los nombres: ");
                parametros[3] = scanner.nextLine();
                System.out.print("Introduce el correo electrónico: ");
                parametros[4] = scanner.nextLine();
                System.out.print("Introduce el apellido: ");
                parametros[5] = scanner.nextLine();
                System.out.print("Introduce el DNI: ");
                parametros[6] = scanner.nextLine();
                break;
            case "ActualizarProductor":
                parametros = new Object[6];
                System.out.print("Introduce el ID del productor: ");
                parametros[0] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Introduce el tipo de producto: ");
                parametros[1] = scanner.nextLine();
                System.out.print("Introduce la certificación: ");
                parametros[2] = scanner.nextLine();
                System.out.print("Introduce el teléfono: ");
                parametros[3] = scanner.nextLine();
                System.out.print("Introduce el correo electrónico: ");
                parametros[4] = scanner.nextLine();
                System.out.print("Introduce los nombres y apellidos: ");
                parametros[5] = scanner.nextLine();
                break;
            case "ActualizarVenta":
                parametros = new Object[4];
                System.out.print("Introduce el ID de la venta: ");
                parametros[0] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Introduce la fecha de la venta (YYYY-MM-DD HH:MM:SS): ");
                parametros[1] = Timestamp.valueOf(scanner.nextLine());
                System.out.print("Introduce el monto total: ");
                parametros[2] = scanner.nextDouble();
                System.out.print("Introduce el ID del cliente: ");
                parametros[3] = scanner.nextInt();
                break;
            case "ActualizarDetalleVenta":
                parametros = new Object[5];
                System.out.print("Introduce el ID del detalle de la venta: ");
                parametros[0] = scanner.nextInt();
                System.out.print("Introduce la cantidad: ");
                parametros[1] = scanner.nextInt();
                System.out.print("Introduce el precio de venta: ");
                parametros[2] = scanner.nextDouble();
                System.out.print("Introduce el ID del producto: ");
                parametros[3] = scanner.nextInt();
                System.out.print("Introduce el ID de la venta: ");
                parametros[4] = scanner.nextInt();
                break;
            case "ActualizarReseña":
                parametros = new Object[6];
                System.out.print("Introduce el ID de la reseña: ");
                parametros[0] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Introduce la fecha (YYYY-MM-DD HH:MM:SS): ");
                parametros[1] = Timestamp.valueOf(scanner.nextLine());
                System.out.print("Introduce el idioma: ");
                parametros[2] = scanner.nextLine();
                System.out.print("Introduce el comentario: ");
                parametros[3] = scanner.nextLine();
                System.out.print("Introduce la calificación: ");
                parametros[4] = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Introduce el estado del producto: ");
                parametros[5] = scanner.nextLine();
                break;
            default:
                System.out.println("Procedimiento almacenado no encontrado.");
                return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            StoredProcedureActualizar procedure = StoredProcedureFactoryActualizar.getStoredProcedureActualizar(procedureName, parametros);
            procedure.execute(connection);
            System.out.println("Procedimiento ejecutado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
