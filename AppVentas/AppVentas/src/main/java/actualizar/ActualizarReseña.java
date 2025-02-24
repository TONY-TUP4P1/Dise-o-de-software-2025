/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actualizar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ActualizarReseña implements StoredProcedureActualizar {
    private int idReseña;
    private Timestamp fecha;
    private String idioma;
    private String comentario;
    private int calificacion;
    private String estadoProducto;

    public ActualizarReseña(int idReseña, Timestamp fecha, String idioma, String comentario, int calificacion, String estadoProducto) {
        this.idReseña = idReseña;
        this.fecha = fecha;
        this.idioma = idioma;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.estadoProducto = estadoProducto;
    }

    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{call ActualizarReseña(?, ?, ?, ?, ?, ?)}";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idReseña);
            stmt.setTimestamp(2, fecha);
            stmt.setString(3, idioma);
            stmt.setString(4, comentario);
            stmt.setInt(5, calificacion);
            stmt.setString(6, estadoProducto);
            stmt.executeUpdate();
        }
    }
}
