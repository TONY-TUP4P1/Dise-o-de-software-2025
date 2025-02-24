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
import java.sql.Timestamp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MostrarRegistrosVenta implements StoredProcedureMostrar {
    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call MostrarRegistrosVenta()}")) {
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Fecha de Venta", "Monto Total", "ID Cliente"}, 0);
            while (rs.next()) {
                int id = rs.getInt("IDVenta");
                Timestamp fechaVenta = rs.getTimestamp("FechaVenta");
                BigDecimal montoTotal = rs.getBigDecimal("MontoTotal");
                int idCliente = rs.getInt("IDCliente");
                model.addRow(new Object[]{id, fechaVenta, montoTotal, idCliente});
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