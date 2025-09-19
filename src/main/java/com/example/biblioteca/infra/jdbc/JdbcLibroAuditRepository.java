package com.example.biblioteca.infra.jdbc;

import com.example.biblioteca.infra.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcLibroAuditRepository {
  public void registrarPrestamo(Long libroId, String titulo){
    String sql = "CREATE TABLE IF NOT EXISTS auditoria (id IDENTITY, libro_id BIGINT, titulo VARCHAR(255));";
    String insert = "INSERT INTO auditoria(libro_id, titulo) VALUES(?,?)";
    try (Connection c = DatabaseConnection.getInstance().getConnection()) {
      try (PreparedStatement st = c.prepareStatement(sql)) { st.execute(); }
      try (PreparedStatement st = c.prepareStatement(insert)) {
        st.setLong(1, libroId); st.setString(2, titulo); st.executeUpdate();
      }
    } catch (Exception e) {
      throw new RuntimeException("Error auditando préstamo", e);
    }
  }
}
