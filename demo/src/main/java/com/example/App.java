package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class App 
{
    public static void main( String[] args )
    {
        // try {
        //     Connection conn =  ConexionBD.conectar();

        //     String sql = "insert into persona (nombre, apellido) values (?, ?)";

        //     PreparedStatement prepared = conn.prepareStatement(sql);

        //     prepared.setString(1, "juan");

        //     prepared.setString(2, "perez");

        //     prepared.executeUpdate();

        //     prepared.close();

        // } catch (SQLException e) {
        //     System.out.println("error: " + e);
        // }

        // -------------------------------------------------------------

        // try {
        //     Connection conn =  ConexionBD.conectar();

        //     String sql = "select * from persona";

        //     PreparedStatement prepared = conn.prepareStatement(sql);

        //     ResultSet rs = prepared.executeQuery();

        //         while (rs.next()) {
        //             String nombre = rs.getString("nombre");
        //             String apellido = rs.getString("apellido");
        //             System.out.println(nombre + " " + apellido);
        //         }

        //     prepared.close();

        // } catch (SQLException e) {
        //     System.out.println("error: " + e);
        // }

        // -------------------------------------------------------------

        // try(Connection conn = PoolConexiones.getConnection();) {
            
        //     PreparedStatement stmt = conn.prepareStatement("insert into persona (nombre, apellido) values (?, ?)");

        //     stmt.setString(1, "johan");
        //     stmt.setString(2, "cardenas");

        //     stmt.executeUpdate();
        // } catch (SQLException e) {
        //     System.out.println("error: " + e);
        // }

        // -------------------------------------------------------------

        // try(Connection conn = PoolConexionJavax.getConnection()) {
        //     PreparedStatement stmt = conn.prepareStatement("insert into persona (nombre, apellido) values (?, ?)");

        //     stmt.setString(1, "pepito");
        //     stmt.setString(2, "cardenas");

        //     stmt.executeUpdate();
        // } catch (SQLException e) {
        //     System.out.println("error: " + e);
        // } 

        
        try(Connection conn = PoolConexionJavax.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet  rs = stmt.executeQuery("SELECT * FROM persona");

            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

            rowSet.populate(rs);

            rs.close();
            stmt.close();

            while (rowSet.next()) {
                System.out.println(rowSet.getString("nombre") + rowSet.getString("apellido"));
            }

            rowSet.beforeFirst();
            while (rowSet.next()) {
                if (rowSet.getString("nombre").equals("johan")) {
                    rowSet.updateString("apellido", "actualizado");
                    rowSet.updateRow();
                }
            }

            conn.setAutoCommit(false);

            rowSet.acceptChanges(conn);
        } catch (SQLException e) {
            System.out.println("error: " + e);
        } 
    }
}
