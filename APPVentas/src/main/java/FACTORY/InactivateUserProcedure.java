/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FACTORY;
package singleton;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InactivateUserProcedure implements Procedure {
    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{CALL inactivateUser(?)}";
        try (CallableStatement callableStatement = connection.prepareCall(sql)) {
            callableStatement.setInt(1, 1); // ID del usuario
            callableStatement.execute();
        }
    }
}
