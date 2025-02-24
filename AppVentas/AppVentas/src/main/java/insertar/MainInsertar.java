/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertar;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class MainInsertar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del procedimiento almacenado: ");
        String procedureName = scanner.nextLine();

        try {
            StoredProcedureInsertar procedure;
            switch (procedureName) {
                case "InsertarCategoriaProducto":
                    System.out.print("Introduce el nombre de la categoría: ");
                    String nombreCategoria = scanner.nextLine();
                    procedure = StoredProcedureFactoryInsertar.getStoredProcedureInsertar(procedureName, nombreCategoria);
                    break;
                case "InsertarProducto":
                    System.out.print("Introduce el stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Introduce el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print("Introduce el lugar de procedencia: ");
                    String lugarProcedencia = scanner.nextLine();
                    System.out.print("Introduce la unidad de medida: ");
                    String unidadMedida = scanner.nextLine();
                    System.out.print("Introduce el precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Introduce el ID de la categoría: ");
                    int idCategoria = scanner.nextInt();
                    procedure = StoredProcedureFactoryInsertar.getStoredProcedureInsertar(procedureName, stock, nombreProducto, lugarProcedencia, unidadMedida, precio, idCategoria);
                    break;
                case "InsertarCliente":
                    System.out.print("Introduce la dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Introduce el teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Introduce los nombres: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Introduce el correo electrónico: ");
                    String correoElectronico = scanner.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Introduce el DNI: ");
                    String dni = scanner.nextLine();
                    procedure = StoredProcedureFactoryInsertar.getStoredProcedureInsertar(procedureName, direccion, telefono, nombres, correoElectronico, apellido, dni);
                    break;
                case "InsertarProductor":
                    System.out.print("Introduce el tipo de producto: ");
                    String tipoProducto = scanner.nextLine();
                    System.out.print("Introduce la certificación: ");
                    String certificacion = scanner.nextLine();
                    System.out.print("Introduce el teléfono: ");
                    String telefonoProductor = scanner.nextLine();
                    System.out.print("Introduce el correo electrónico: ");
                    String correoElectronicoProductor = scanner.nextLine();
                    System.out.print("Introduce los nombres y apellidos: ");
                    String nombresApellidos = scanner.nextLine();
                    procedure = StoredProcedureFactoryInsertar.getStoredProcedureInsertar(procedureName, tipoProducto, certificacion, telefonoProductor, correoElectronicoProductor, nombresApellidos);
                    break;
                case "InsertarVenta":
                    System.out.print("Introduce la fecha de venta (YYYY-MM-DD HH:MM:SS): ");
                    String fechaVentaStr = scanner.nextLine();
                    Timestamp fechaVenta = Timestamp.valueOf(fechaVentaStr);
                    System.out.print("Introduce el monto total: ");
                    double montoTotal = scanner.nextDouble();
                    System.out.print("Introduce el ID del cliente: ");
                    int idCliente = scanner.nextInt();
                    procedure = StoredProcedureFactoryInsertar.getStoredProcedureInsertar(procedureName, fechaVenta, montoTotal, idCliente);
                    break;
                case "InsertarDetalleVenta":
                    System.out.print("Introduce la cantidad: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Introduce el precio de venta: ");
                    double precioVenta = scanner.nextDouble();
                    System.out.print("Introduce el ID del producto: ");
                    int productoID = scanner.nextInt();
                    System.out.print("Introduce el ID de la venta: ");
                    int ventaID = scanner.nextInt();
                    procedure = StoredProcedureFactoryInsertar.getStoredProcedureInsertar(procedureName, cantidad, precioVenta, productoID, ventaID);
                    break;
                case "InsertarReseña":
                    System.out.print("Introduce la fecha (YYYY-MM-DD HH:MM:SS): ");
                    String fechaStr = scanner.nextLine();
                    Timestamp fecha = Timestamp.valueOf(fechaStr);
                    System.out.print("Introduce el idioma: ");
                    String idioma = scanner.nextLine();
                    System.out.print("Introduce el comentario: ");
                    String comentario = scanner.nextLine();
                    System.out.print("Introduce la calificación: ");
                    int calificacion = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Introduce el estado del producto: ");
                    String estadoProducto = scanner.nextLine();
                    procedure = StoredProcedureFactoryInsertar.getStoredProcedureInsertar(procedureName, fecha, idioma, comentario, calificacion, estadoProducto);
                    break;
                default:
                    throw new IllegalArgumentException("Procedimiento almacenado no encontrado");
            }
            procedure.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
