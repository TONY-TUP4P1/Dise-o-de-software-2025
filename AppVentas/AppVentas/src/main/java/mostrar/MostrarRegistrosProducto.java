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

public class MostrarRegistrosProducto implements StoredProcedureMostrar {
    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call MostrarRegistrosProducto()}")) {
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Stock", "Lugar Procedencia", "Unidad Medida", "Precio", "ID Categoría","Estado"}, 0);
            while (rs.next()) {
                int id = rs.getInt("IDProducto");
                String nombre = rs.getString("Nombre");
                int stock = rs.getInt("Stock");
                String lugarProcedencia = rs.getString("LugarProcedencia");
                String unidadMedida = rs.getString("UnidadMedida");
                BigDecimal precio = rs.getBigDecimal("Precio");
                int idCategoria = rs.getInt("IDCategoriaProducto");
                String Estado = rs.getString("Estado");
                model.addRow(new Object[]{id, nombre, stock, lugarProcedencia, unidadMedida, precio, idCategoria, Estado});
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
