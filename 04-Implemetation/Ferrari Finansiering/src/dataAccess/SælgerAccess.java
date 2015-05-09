package dataAccess;

import java.sql.*;

import domain.Sælger;


public class SælgerAccess
{
  private static final String SELECT = "SELECT navn FROM sælger WHERE sælgerid = ?";
  //  private static final String SELECT_MANY = "SELECT  FROM  WHERE ";
  private static final String INSERT = "INSERT INTO sælger(sælgernavn) VALUES (?)";
  private static final String UPDATE = "UPDATE sælger SET sælgernavn WHERE sælgerid = ?";
  private static final String DELETE = "DELETE FROM sælger WHERE sælgerid = ?";
  
  
  public SælgerAccess()
  {
    
  }
  
  
  /*
   * Create
   */
  public void createSælger( Sælger sælger ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      createSælgernavn( connection, sælger );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
        //        System.out.println("sælger, connection close");
      }
    }
  }
  
  public void createSælgernavn( Connection connection, Sælger sælger ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( INSERT ); 
      statement.setString( 1, sælger.getSælgernavn() );
      statement.execute();
    }
    finally
    {
      if ( statement != null )
      {
        statement.close();
        //        System.out.println("sælger, statement close");
      }
    }
  }
  
  /*
   * Read
   */
  public Sælger readSælgernavn( int sælgerid ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return readSælgernavn( connection, sælgerid );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public Sælger readSælgernavn( Connection connection, int sælgerid ) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    Sælger sælger = null;
    try
    {
      statement = connection.prepareStatement( SELECT );
      statement.setInt( 1, sælgerid );
      resultset = statement.executeQuery();
      sælger = new Sælger();
      sælger.setSælgerid( sælgerid );
      sælger.setSælgernavn( resultset.getString( "sælgernavn" ) );
      return sælger;
    }
    finally
    {
      
    }
  }
  
  
  
  /*
   * Update
   */
      
  public void updateSælgernavn( Sælger sælger ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      updateSælgernavn( connection, sælger );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void updateSælgernavn( Connection connection, Sælger sælger ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( UPDATE );
      statement.setString( 1, sælger.getSælgernavn() );
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
  public void deleteSælger( int sælgerid ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      deleteSælger( connection, sælgerid );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void deleteSælger( Connection connection, int sælgerid ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( DELETE );
      statement.setInt( 1, sælgerid );
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
