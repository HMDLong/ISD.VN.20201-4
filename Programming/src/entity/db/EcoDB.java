package entity.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import entity.bike.Bike;
import entity.bike.Ebike;
import entity.invoice.Invoice;

/**
 * Responsible for connection to database.
 *
 * @author Group4
 *
 */
public class EcoDB {
  private static Connection conn;
  	/**
	 * This method get connect to database
	 */
  public static Connection getConnection() {
    if(conn != null) {
      return conn;
    }
    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ecobike", "postgres", "robinhieu2310");
      System.out.println("Connect to database successfully");
    } catch(Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
  
  public static void main(String[] args) {
//    EcoDB.getConnection();
  }
}
