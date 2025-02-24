/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarCliente implements StoredProcedureActualizar {
    private int idCliente;
    private String direccion;
    private String telefono;
    private String nombres;
    private String correoElectronico;
    private String apellido;
    private String dni;

    public ActualizarCliente(int idCliente, String direccion, String telefono, String nombres, String correoElectronico, String apellido, String dni) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombres = nombres;
        this.correoElectronico = correoElectronico;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call ActualizarCliente(?, ?, ?, ?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.setString(2, direccion);
            stmt.setString(3, telefono);
            stmt.setString(4, nombres);
            stmt.setString(5, correoElectronico);
            stmt.setString(6, apellido);
            stmt.setString(7, dni);
            stmt.executeUpdate();
        }
    }
}
