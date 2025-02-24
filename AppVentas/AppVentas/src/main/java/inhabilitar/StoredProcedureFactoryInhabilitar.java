/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inhabilitar;

public class StoredProcedureFactoryInhabilitar {
    public static StoredProcedureInhabilitar getStoredProcedureInhabilitar(String procedureName, Object... params) {
        switch (procedureName) {
            case "InhabilitarProducto":
                return new InhabilitarProducto((int) params[0]);
            case "InhabilitarCliente":
                return new InhabilitarCliente((int) params[0]);
            default:
                throw new IllegalArgumentException("Procedimiento almacenado no encontrado: " + procedureName);
        }
    }
}
