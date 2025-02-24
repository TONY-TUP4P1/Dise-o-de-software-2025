/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarProducto implements StoredProcedureActualizar {
    private int idProducto;
    private int stock;
    private String nombre;
    private String lugarProcedencia;
    private String unidadMedida;
    private double precio;
    private int idCategoriaProducto;

    public ActualizarProducto(int idProducto, int stock, String nombre, String lugarProcedencia, String unidadMedida, double precio, int idCategoriaProducto) {
        this.idProducto = idProducto;
        this.stock = stock;
        this.nombre = nombre;
        this.lugarProcedencia = lugarProcedencia;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
        this.idCategoriaProducto = idCategoriaProducto;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call ActualizarProducto(?, ?, ?, ?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProducto);
            stmt.setInt(2, stock);
            stmt.setString(3, nombre);
            stmt.setString(4, lugarProcedencia);
            stmt.setString(5, unidadMedida);
            stmt.setDouble(6, precio);
            stmt.setInt(7, idCategoriaProducto);
            stmt.executeUpdate();
        }
    }
}
