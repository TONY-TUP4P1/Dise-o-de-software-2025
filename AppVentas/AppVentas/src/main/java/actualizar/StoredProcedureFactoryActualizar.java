/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Timestamp;

public class StoredProcedureFactoryActualizar {
    public static StoredProcedureActualizar getStoredProcedureActualizar(String procedureName, Object... params) {
        switch (procedureName) {
            case "ActualizarCategoriaProducto":
                return new ActualizarCategoriaProducto((int) params[0], (String) params[1]);
            case "ActualizarProducto":
                return new ActualizarProducto((int) params[0], (int) params[1], (String) params[2], (String) params[3], (String) params[4], (double) params[5], (int) params[6]);
            case "ActualizarCliente":
                return new ActualizarCliente((int) params[0], (String) params[1], (String) params[2], (String) params[3], (String) params[4], (String) params[5], (String) params[6]);
            case "ActualizarProductor":
                return new ActualizarProductor((int) params[0], (String) params[1], (String) params[2], (String) params[3], (String) params[4], (String) params[5]);
            case "ActualizarVenta":
                return new ActualizarVenta((int) params[0], (Timestamp) params[1], (double) params[2], (int) params[3]);
            case "ActualizarDetalleVenta":
                return new ActualizarDetalleVenta((int) params[0], (int) params[1], (double) params[2], (int) params[3], (int) params[4]);
            case "ActualizarReseña":
                return new ActualizarReseña((int) params[0], (Timestamp) params[1], (String) params[2], (String) params[3], (int) params[4], (String) params[5]);
            default:
                throw new IllegalArgumentException("Procedimiento almacenado no encontrado: " + procedureName);
        }
    }
}
