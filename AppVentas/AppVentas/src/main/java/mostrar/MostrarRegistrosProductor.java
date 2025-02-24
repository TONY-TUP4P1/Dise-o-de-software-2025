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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MostrarRegistrosProductor implements StoredProcedureMostrar {
    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call MostrarRegistrosProductor()}")) {
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombres y Apellidos", "Tipo de Producto", "Certificación", "Teléfono", "Correo Electrónico"}, 0);
            while (rs.next()) {
                int id = rs.getInt("IDProductor");
                String nombresApellidos = rs.getString("NombresApellidos");
                String tipoProducto = rs.getString("TipoProducto");
                String certificacion = rs.getString("Certificacion");
                String telefono = rs.getString("Telefono");
                String correoElectronico = rs.getString("CorreoElectronico");
                model.addRow(new Object[]{id, nombresApellidos, tipoProducto, certificacion, telefono, correoElectronico});
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
