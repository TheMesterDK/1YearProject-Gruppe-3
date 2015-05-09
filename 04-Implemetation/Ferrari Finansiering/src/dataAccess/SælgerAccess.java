package dataAccess;

import java.sql.*;

import domain.S�lger;


public class S�lgerAccess
{
  private static final String SELECT = "SELECT navn FROM s�lger WHERE s�lgerid = ?";
  //  private static final String SELECT_MANY = "SELECT  FROM  WHERE ";
  private static final String INSERT = "INSERT INTO s�lger(s�lgernavn) VALUES (?)";
  private static final String UPDATE = "UPDATE s�lger SET s�lgernavn WHERE s�lgerid = ?";
  private static final String DELETE = "DELETE FROM s�lger WHERE s�lgerid = ?";
  
  
  public S�lgerAccess()
  {
    
  }
  
  
  /*
   * Create
   */
  public void createS�lger( S�lger s�lger ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      createS�lgernavn( connection, s�lger );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
        //        System.out.println("s�lger, connection close");
      }
    }
  }
  
  public void createS�lgernavn( Connection connection, S�lger s�lger ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( INSERT ); 
      statement.setString( 1, s�lger.getS�lgernavn() );
      statement.execute();
    }
    finally
    {
      if ( statement != null )
      {
        statement.close();
        //        System.out.println("s�lger, statement close");
      }
    }
  }
  
  /*
   * Read
   */
  public S�lger readS�lgernavn( int s�lgerid ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return readS�lgernavn( connection, s�lgerid );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public S�lger readS�lgernavn( Connection connection, int s�lgerid ) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    S�lger s�lger = null;
    try
    {
      statement = connection.prepareStatement( SELECT );
      statement.setInt( 1, s�lgerid );
      resultset = statement.executeQuery();
      s�lger = new S�lger();
      s�lger.setS�lgerid( s�lgerid );
      s�lger.setS�lgernavn( resultset.getString( "s�lgernavn" ) );
      return s�lger;
    }
    finally
    {
      
    }
  }
  
  
  
  /*
   * Update
   */
      
  public void updateS�lgernavn( S�lger s�lger ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      updateS�lgernavn( connection, s�lger );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void updateS�lgernavn( Connection connection, S�lger s�lger ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( UPDATE );
      statement.setString( 1, s�lger.getS�lgernavn() );
      statement.execute();
      
    }
    finally
    {
      if ( statement != null )
      {
        statement.close();
      }
    }
  }
  
  
  /*
   * Delete
   */
  public void deleteS�lger( int s�lgerid ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      deleteS�lger( connection, s�lgerid );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void deleteS�lger( Connection connection, int s�lgerid ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( DELETE );
      statement.setInt( 1, s�lgerid );
      statement.execute();
    }
    finally
    {
      if ( statement != null )
      {
        statement.close();
      }
    }
  }
  
  
}
