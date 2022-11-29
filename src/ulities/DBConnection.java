/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBConnection {

  public static Connection getConnection() throws Exception {
    String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName+";encrypt=true;trustServerCertificate=true;";
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    return DriverManager.getConnection(url, userID, password);
  }

  private final static String serverName = "localhost"; //127.0.0.1
  private final static String dbName = "DuAn";
  private final static String portNumber = "1433";
  private final static String userID = "sa";
  private final static String password = "1";
    public static void main(String[] args) {
      try {
          getConnection();
          System.out.println("Thanh cong");
      } catch (Exception ex) {
          Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
}
