/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ActualizarVenta implements StoredProcedureActualizar {
    private int idVenta;
    private Timestamp fechaVenta;
    private double montoTotal;
    private int idCliente;

    public ActualizarVenta(int idVenta, Timestamp fechaVenta, double montoTotal, int idCliente) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.idCliente = idCliente;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call ActualizarVenta(?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idVenta);
            stmt.setTimestamp(2, fechaVenta);
            stmt.setDouble(3, montoTotal);
            stmt.setInt(4, idCliente);
            stmt.executeUpdate();
        }
    }
}