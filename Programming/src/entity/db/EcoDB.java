package entity.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class EcoDB {
  private static Connection conn;
  
  public static Connection getConnection() {
    if(conn != null) {
      return conn;
    }
    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/thanhtoan", "postgres", "longkkrr14");
      System.out.println("Connect to database successfully");
    } catch(Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
  
  public static void main(String[] args) {
    EcoDB.getConnection();
  }
}
