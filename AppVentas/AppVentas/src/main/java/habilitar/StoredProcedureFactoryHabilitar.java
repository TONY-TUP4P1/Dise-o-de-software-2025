/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habilitar;

public class StoredProcedureFactoryHabilitar {
    public static StoredProcedureHabilitar getStoredProcedureHabilitar(String procedureName, Object... params) {
        switch (procedureName) {
            case "HabilitarProducto":
                return new HabilitarProducto((int) params[0]);
            case "HabilitarCliente":
                return new HabilitarCliente((int) params[0]);
            default:
                throw new IllegalArgumentException("Procedimiento almacenado no encontrado: " + procedureName);
        }
    }
}
