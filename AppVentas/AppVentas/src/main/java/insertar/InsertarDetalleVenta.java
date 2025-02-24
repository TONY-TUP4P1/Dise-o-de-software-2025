/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertar;

/**
 *
 * @author USER
 */
import com.mycompany.appventas.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertarDetalleVenta implements StoredProcedureInsertar {
    private int cantidad;
    private double precioVenta;
    private int productoID;
    private int ventaID;

    public InsertarDetalleVenta(int cantidad, double precioVenta, int productoID, int ventaID) {
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.productoID = productoID;
        this.ventaID = ventaID;
    }

    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertarDetalleVenta(?, ?, ?, ?)}")) {
            stmt.setInt(1, cantidad);
            stmt.setDouble(2, precioVenta);
            stmt.setInt(3, productoID);
            stmt.setInt(4, ventaID);
            stmt.execute();
            System.out.println("Detalle de venta insertado correctamente.");
        }
    }
}
