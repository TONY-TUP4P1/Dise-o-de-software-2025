/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertar;

import com.mycompany.appventas.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertarCategoriaProducto implements StoredProcedureInsertar {
    private String nombre;

    public InsertarCategoriaProducto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertarCategoriaProducto(?)}")) {
            stmt.setString(1, nombre);
            stmt.execute();
            System.out.println("Categoría de producto insertada correctamente.");
        }
    }
}
