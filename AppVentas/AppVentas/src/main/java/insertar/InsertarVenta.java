/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertar;

import java.sql.Timestamp;

import com.mycompany.appventas.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsertarVenta implements StoredProcedureInsertar {
    private Timestamp fechaVenta;
    private double montoTotal;
    private int idCliente;

    public InsertarVenta(Timestamp fechaVenta, double montoTotal, int idCliente) {
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.idCliente = idCliente;
    }

    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertarVenta(?, ?, ?)}")) {
            stmt.setTimestamp(1, fechaVenta);
            stmt.setDouble(2, montoTotal);
            stmt.setInt(3, idCliente);
            stmt.execute();
            System.out.println("Venta insertada correctamente.");
        }
    }
}
