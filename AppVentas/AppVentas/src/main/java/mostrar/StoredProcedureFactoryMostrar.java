/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mostrar;


public class StoredProcedureFactoryMostrar {
    public static StoredProcedureMostrar getStoredProcedureMostrar(String procedureName) {
        switch (procedureName) {
            case "MostrarRegistrosCategoriaProducto":
                return new MostrarRegistrosCategoriaProducto();
            case "MostrarRegistrosProducto":
                return new MostrarRegistrosProducto();
            case "MostrarRegistrosClientes":
                return new MostrarRegistrosClientes();
            case "MostrarRegistrosProductor":
                return new MostrarRegistrosProductor();
            case "MostrarRegistrosVenta":
                return new MostrarRegistrosVenta();
            case "MostrarRegistrosDetalleVenta":
                return new MostrarRegistrosDetalleVenta();
            case "MostrarRegistrosReseña":
                return new MostrarRegistrosReseña();
            default:
                throw new IllegalArgumentException("Procedimiento almacenado no encontrado");
        }
    }
}
