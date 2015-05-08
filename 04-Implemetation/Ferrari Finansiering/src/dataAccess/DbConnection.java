package dataAccess;

import java.sql.*;

public class DbConnection
{
  
  private static final String CONNECTION_URL = "jdbc:hsqldb:hsql://localhost/mydatabase";
  private static final String DB_USER = "SA";
  private static final String DB_PASSWORD = "";
  private Connection connection = null;
  
  
  public DbConnection() throws SQLException
  {
    connection = DriverManager.getConnection( CONNECTION_URL, DB_USER, DB_PASSWORD );
//    connection.setAutoCommit( false );
  }
  
  
  public void close() throws SQLException
  {
    if ( this.connection != null )
    {
      this.connection.close();
      this.connection = null;
    }
    else
    {
      throw new SQLException( "Connection not available (null). Not closed" );
    }
  }
  
  
  public void commit() throws SQLException
  {
    if ( this.connection != null )
    {
      this.connection.commit();
    }
    else
    {
      throw new SQLException( "Connection not available (null). Not committed" );
    }
  }
  
  
  public void rollback() throws SQLException
  {
    if ( this.connection != null )
    {
      this.connection.rollback();
    }
    else
    {
      throw new SQLException( "Connection not available (null). Not rolled back" );
    }
  }
  
  
  public Connection getConnection()
  {
    return connection;
  }
  
}
