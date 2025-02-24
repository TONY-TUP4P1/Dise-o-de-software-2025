/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inhabilitar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InhabilitarProducto implements StoredProcedureInhabilitar {
    private int idProducto;

    public InhabilitarProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call InhabilitarProducto(?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProducto);
            stmt.executeUpdate();
        }
    }
}
