package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Sælger;

public class SælgerAccess
{
  private static final String SELECT = "SELECT sælgernavn FROM sælger WHERE sælgerid = ?";
  private static final String INSERT = "INSERT INTO sælger(sælgernavn) VALUES (?)";
  private static final String UPDATE = "UPDATE sælger SET sælgernavn = ? WHERE sælgerid = ?";
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
      connection.commit();
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
      while ( resultset.next() )
      {
        sælger.setSælgernavn( resultset.getString( "sælgernavn" ) );
      }
      return sælger;
    }
    finally
    {
      if ( resultset != null )
      {
        resultset.close();
      }
      if ( statement != null )
      {
        statement.close();
      }
    }
  }
  
  /*
   * Update
   */
  
  public void updateSælger( Sælger sælger ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      updateSælger( connection, sælger );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void updateSælger( Connection connection, Sælger sælger ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( UPDATE );
      statement.setString( 1, sælger.getSælgernavn() );
      statement.setInt( 2, sælger.getSælgerid() );
      statement.execute();
      connection.commit();
      
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
      connection.commit();
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
