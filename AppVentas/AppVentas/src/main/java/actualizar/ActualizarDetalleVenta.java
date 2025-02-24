/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarDetalleVenta implements StoredProcedureActualizar {
    private int idDetalleVenta;
    private int cantidad;
    private double precioVenta;
    private int productoID;
    private int ventaID;

    public ActualizarDetalleVenta(int idDetalleVenta, int cantidad, double precioVenta, int productoID, int ventaID) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.productoID = productoID;
        this.ventaID = ventaID;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call ActualizarDetalleVenta(?, ?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idDetalleVenta);
            stmt.setInt(2, cantidad);
            stmt.setDouble(3, precioVenta);
            stmt.setInt(4, productoID);
            stmt.setInt(5, ventaID);
            stmt.executeUpdate();
        }
    }
}

