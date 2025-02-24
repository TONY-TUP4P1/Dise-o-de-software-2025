/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarProductor implements StoredProcedureActualizar {
    private int idProductor;
    private String tipoProducto;
    private String certificacion;
    private String telefono;
    private String correoElectronico;
    private String nombresApellidos;

    public ActualizarProductor(int idProductor, String tipoProducto, String certificacion, String telefono, String correoElectronico, String nombresApellidos) {
        this.idProductor = idProductor;
        this.tipoProducto = tipoProducto;
        this.certificacion = certificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.nombresApellidos = nombresApellidos;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call ActualizarProductor(?, ?, ?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProductor);
            stmt.setString(2, tipoProducto);
            stmt.setString(3, certificacion);
            stmt.setString(4, telefono);
            stmt.setString(5, correoElectronico);
            stmt.setString(6, nombresApellidos);
            stmt.executeUpdate();
        }
    }
}
