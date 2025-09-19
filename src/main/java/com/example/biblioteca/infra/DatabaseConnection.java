package com.example.biblioteca.infra;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public final class DatabaseConnection {
  private static volatile DatabaseConnection instance;
  private final HikariDataSource ds;

  private DatabaseConnection() {
    HikariConfig cfg = new HikariConfig();
    cfg.setJdbcUrl("jdbc:h2:mem:biblioteca;DB_CLOSE_DELAY=-1;MODE=LEGACY");
    cfg.setUsername("sa");
    cfg.setPassword("");
    this.ds = new HikariDataSource(cfg);
  }

  public static DatabaseConnection getInstance() {
    if (instance == null) {
      synchronized (DatabaseConnection.class) {
        if (instance == null) instance = new DatabaseConnection();
      }
    }
    return instance;
  }

  public Connection getConnection() throws SQLException { return ds.getConnection(); }
}
