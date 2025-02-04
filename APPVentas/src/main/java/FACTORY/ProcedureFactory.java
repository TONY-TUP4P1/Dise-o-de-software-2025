/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FACTORY;
package singleton;

public class ProcedureFactory {
    public static Procedure createProcedure(String procedureName) {
        switch (procedureName) {
            case "Procedure1":
                return new Procedure1();
            case "Procedure2":
                return new Procedure2();
            case "InactivateUserProcedure":
                return new InactivateUserProcedure();
            default:
                throw new IllegalArgumentException("Unknown procedure: " + procedureName);
        }
    }
}

