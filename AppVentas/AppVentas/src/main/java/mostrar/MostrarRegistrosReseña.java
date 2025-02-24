/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mostrar;

import com.mycompany.appventas.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MostrarRegistrosReseña implements StoredProcedureMostrar {
    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call MostrarRegistrosReseña()}")) {
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Fecha", "Idioma", "Comentario", "Calificación", "Estado del Producto"}, 0);
            while (rs.next()) {
                int id = rs.getInt("IDReseña");
                Timestamp fecha = rs.getTimestamp("Fecha");
                String idioma = rs.getString("Idioma");
                String comentario = rs.getString("Comentario");
                int calificacion = rs.getInt("Calificacion");
                String estadoProducto = rs.getString("EstadoProducto");
                model.addRow(new Object[]{id, fecha, idioma, comentario, calificacion, estadoProducto});
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
