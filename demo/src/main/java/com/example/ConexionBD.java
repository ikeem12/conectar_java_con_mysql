package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/prueba_conexion_con_java";
    private static final String USER = "root";
    private static final String PASSWORD = "johancar12";

    public static Connection conectar() throws SQLException {
        Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        return conexion;
    }
}
