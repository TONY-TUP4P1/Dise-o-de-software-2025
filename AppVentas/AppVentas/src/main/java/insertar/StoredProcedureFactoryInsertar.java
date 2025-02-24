/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertar;

import java.sql.Timestamp;

public class StoredProcedureFactoryInsertar {
    public static StoredProcedureInsertar getStoredProcedureInsertar(String procedureName, Object... params) {
        switch (procedureName) {
            case "InsertarCategoriaProducto":
                return new InsertarCategoriaProducto((String) params[0]);
            case "InsertarProducto":
                return new InsertarProducto((int) params[0], (String) params[1], (String) params[2], (String) params[3], (double) params[4], (int) params[5]);
            case "InsertarCliente":
                return new InsertarCliente((String) params[0], (String) params[1], (String) params[2], (String) params[3], (String) params[4], (String) params[5]);
            case "InsertarProductor":
                return new InsertarProductor((String) params[0], (String) params[1], (String) params[2], (String) params[3], (String) params[4]);
            case "InsertarVenta":
                return new InsertarVenta((Timestamp) params[0], (double) params[1], (int) params[2]);
            case "InsertarDetalleVenta":
                return new InsertarDetalleVenta((int) params[0], (double) params[1], (int) params[2], (int) params[3]);
            case "InsertarReseña":
                return new InsertarReseña((Timestamp) params[0], (String) params[1], (String) params[2], (int) params[3], (String) params[4]);
            default:
                throw new IllegalArgumentException("Procedimiento almacenado no encontrado");
        }
    }
}
