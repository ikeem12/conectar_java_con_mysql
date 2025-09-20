package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PoolConexionJavax {
    private static  HikariConfig config = new HikariConfig();

    /**
     * DataSource es un interfaza que me permite que una aplicacion no se acople mucho aun solo 
     * pool, es decir, pueda cambiar de Hikari a apache DBCP. Esto permite cambiar el pool
    *  sin afectar el resto del código, y facilita pruebas y mantenimiento.
     */
    private static final DataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/prueba_conexion_con_java");
        config.setUsername("user");
        config.setPassword("password");

        // Propiedades opcionales para optimizar
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        config.setConnectionTimeout(30000);
        config.isAutoCommit();


        ds = new HikariDataSource(config);
    }

    private PoolConexionJavax() {}

    public static Connection getConnection() throws SQLException, SQLTimeoutException {
        return ds.getConnection(); 
    }
}
