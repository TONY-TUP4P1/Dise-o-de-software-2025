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

public class InsertarProductor implements StoredProcedureInsertar {
    private String tipoProducto;
    private String certificacion;
    private String telefono;
    private String correoElectronico;
    private String nombresApellidos;

    public InsertarProductor(String tipoProducto, String certificacion, String telefono, String correoElectronico, String nombresApellidos) {
        this.tipoProducto = tipoProducto;
        this.certificacion = certificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.nombresApellidos = nombresApellidos;
    }

    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertarProductor(?, ?, ?, ?, ?)}")) {
            stmt.setString(1, tipoProducto);
            stmt.setString(2, certificacion);
            stmt.setString(3, telefono);
            stmt.setString(4, correoElectronico);
            stmt.setString(5, nombresApellidos);
            stmt.execute();
            System.out.println("Productor insertado correctamente.");
        }
    }
}
