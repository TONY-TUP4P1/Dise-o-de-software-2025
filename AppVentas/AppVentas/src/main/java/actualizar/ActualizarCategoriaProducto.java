/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarCategoriaProducto implements StoredProcedureActualizar {
    private int idCategoriaProducto;
    private String nombre;

    public ActualizarCategoriaProducto(int idCategoriaProducto, String nombre) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombre = nombre;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call ActualizarCategoriaProducto(?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCategoriaProducto);
            stmt.setString(2, nombre);
            stmt.executeUpdate();
        }
    }
}
