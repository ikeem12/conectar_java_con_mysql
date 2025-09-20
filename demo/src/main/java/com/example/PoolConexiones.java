package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PoolConexiones {
    private static  HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/prueba_conexion_con_java");
        config.setUsername("root");
        config.setPassword("johancar12");

        // Propiedades opcionales para optimizar
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        config.setConnectionTimeout(30000);
        config.isAutoCommit();


        ds = new HikariDataSource(config);
    }

    private PoolConexiones() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection(); 
    }
}
