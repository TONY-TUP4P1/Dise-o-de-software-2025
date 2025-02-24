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

public class InsertarProducto implements StoredProcedureInsertar {
    private int stock;
    private String nombre;
    private String lugarProcedencia;
    private String unidadMedida;
    private double precio;
    private int idCategoriaProducto;

    public InsertarProducto(int stock, String nombre, String lugarProcedencia, String unidadMedida, double precio, int idCategoriaProducto) {
        this.stock = stock;
        this.nombre = nombre;
        this.lugarProcedencia = lugarProcedencia;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
        this.idCategoriaProducto = idCategoriaProducto;
    }

    @Override
    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertarProducto(?, ?, ?, ?, ?, ?)}")) {
            stmt.setInt(1, stock);
            stmt.setString(2, nombre);
            stmt.setString(3, lugarProcedencia);
            stmt.setString(4, unidadMedida);
            stmt.setDouble(5, precio);
            stmt.setInt(6, idCategoriaProducto);
            stmt.execute();
            System.out.println("Producto insertado correctamente.");
        }
    }
}
