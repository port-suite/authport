package com.port.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Storage {
  private Connection connection;
  private Statement statement;

  public Storage() {
    try {
      this.connection = DriverManager.getConnection("jdbc:sqlite:.db");
      this.statement = connection.createStatement();
    } catch (SQLException e) {
      e.printStackTrace(System.err);
    }
  }

  public User getUserWithEmail(String email) {
    try {
      String query = "SELECT * FROM user WHERE email = '%s'";
      ResultSet rs = statement.executeQuery(String.format(query, email));
      while (rs.next()) {
        return new User(rs.getString("email"), rs.getString("password"), rs.getString("name"),
            rs.getString("surname"), rs.getInt("id"), rs.getString("auth_token"), rs.getInt("logged_in_count"));
      }
    } catch (SQLException e) {
      return new User("", "", "", "", -1, "", -1);
    }
    return new User("", "", "", "", -1, "", -1);
  }
}
