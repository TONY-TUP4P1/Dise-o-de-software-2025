/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FACTORY;
package singleton;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserProcedure implements Procedure {
    @Override
    public void execute(Connection connection) throws SQLException {
        String sql = "{CALL insertUser(?, ?)}";
        try (CallableStatement callableStatement = connection.prepareCall(sql)) {
            callableStatement.setString(1, "Juan");
            callableStatement.setString(2, "juan@example.com");
            callableStatement.execute();
        }
    }
}

