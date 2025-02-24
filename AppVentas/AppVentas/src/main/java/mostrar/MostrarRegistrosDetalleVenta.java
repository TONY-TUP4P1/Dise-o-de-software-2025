/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mostrar;

import com.mycompany.appventas.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MostrarRegistrosDetalleVenta implements StoredProcedureMostrar {
    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call MostrarRegistrosDetalleVenta()}")) {
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Cantidad", "Precio de Venta", "ID Producto", "ID Venta"}, 0);
            while (rs.next()) {
                int id = rs.getInt("IDDetalleVenta");
                int cantidad = rs.getInt("Cantidad");
                BigDecimal precioVenta = rs.getBigDecimal("PrecioVenta");
                int productoID = rs.getInt("ProductoID");
                int ventaID = rs.getInt("VentaID");
                model.addRow(new Object[]{id, cantidad, precioVenta, productoID, ventaID});
            }
            JTable table = new JTable(model);
            JFrame frame = new JFrame("Resultados");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}
