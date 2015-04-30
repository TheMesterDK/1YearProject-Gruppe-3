package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
  
  private static final String CONNECTION_URL = "jdbc:hsqldb:hsql://localhost/mydatabase";
  private static final String DB_USER = "SA";
  private static final String DB_PASSWORD = "";
  private Connection connection = null;
  
  
  public DbConnection() throws SQLException
  {
    connection = DriverManager.getConnection( CONNECTION_URL, DB_USER, DB_PASSWORD );
    connection.setAutoCommit( false );
  }
  
  
  public Connection getConnection()
  {
    return connection;
  }
}
