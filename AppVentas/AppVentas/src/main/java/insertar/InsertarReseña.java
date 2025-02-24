/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insertar;

import java.sql.Timestamp;

/**
 *
 * @author USER
 */
import com.mycompany.appventas.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsertarReseña implements StoredProcedureInsertar {
    private Timestamp fecha;
    private String idioma;
    private String comentario;
    private int calificacion;
    private String estadoProducto;

    public InsertarReseña(Timestamp fecha, String idioma, String comentario, int calificacion, String estadoProducto) {
        this.fecha = fecha;
        this.idioma = idioma;
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.estadoProducto = estadoProducto;
    }

    public void execute() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{call InsertarReseña(?, ?, ?, ?, ?)}")) {
            stmt.setTimestamp(1, fecha);
            stmt.setString(2, idioma);
            stmt.setString(3, comentario);
            stmt.setInt(4, calificacion);
            stmt.setString(5, estadoProducto);
            stmt.execute();
            System.out.println("Reseña insertada correctamente.");
        }
    }
}
