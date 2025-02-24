/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertar;

/**
 *
 * @author USER
 */
import com.mycompany.appventas.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertarCliente implements StoredProcedureInsertar {
    private String direccion;
    private String telefono;
    private String nombres;
    private String correoElectronico;
    private String apellido;
    private String dni;

    public InsertarCliente(String direccion, String telefono, String nombres, String correoElectronico, String apellido, String dni) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombres = nombres;
        this.correoElectronico = correoElectronico;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertarCliente(?, ?, ?, ?, ?, ?)}")) {
            stmt.setString(1, direccion);
            stmt.setString(2, telefono);
            stmt.setString(3, nombres);
            stmt.setString(4, correoElectronico);
            stmt.setString(5, apellido);
            stmt.setString(6, dni);
            stmt.execute();
            System.out.println("Cliente insertado correctamente.");
        }
    }
}
