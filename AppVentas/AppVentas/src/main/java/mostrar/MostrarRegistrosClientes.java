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

public class MostrarRegistrosClientes implements StoredProcedureMostrar {
    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call MostrarRegistrosClientes()}")) {
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombres", "Apellido", "Dirección", "Teléfono", "Correo Electrónico", "DNI","Estado"}, 0);
            while (rs.next()) {
                int id = rs.getInt("IDCliente");
                String nombres = rs.getString("Nombres");
                String apellido = rs.getString("Apellido");
                String direccion = rs.getString("Direccion");
                String telefono = rs.getString("Telefono");
                String correoElectronico = rs.getString("CorreoElectronico");
                String dni = rs.getString("DNI");
                String Estado = rs.getString("Estado");
                model.addRow(new Object[]{id, nombres, apellido, direccion, telefono, correoElectronico, dni, Estado});
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
