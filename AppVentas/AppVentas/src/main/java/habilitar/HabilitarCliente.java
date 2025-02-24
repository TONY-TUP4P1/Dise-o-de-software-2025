/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habilitar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HabilitarCliente implements StoredProcedureHabilitar {
    private int idCliente;

    public HabilitarCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call HabilitarCliente(?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        }
    }
}
