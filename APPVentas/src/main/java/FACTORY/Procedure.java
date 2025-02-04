/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FACTORY;
package singleton;

import java.sql.Connection;
import java.sql.SQLException;

public interface Procedure {
    void execute(Connection connection) throws SQLException;
}
