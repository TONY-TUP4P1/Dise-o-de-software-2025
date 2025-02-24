/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habilitar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HabilitarProducto implements StoredProcedureHabilitar {
    private int idProducto;

    public HabilitarProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call HabilitarProducto(?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProducto);
            stmt.executeUpdate();
        }
    }
}
