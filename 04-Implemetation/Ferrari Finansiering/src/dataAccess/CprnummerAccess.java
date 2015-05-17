package dataAccess;

import java.sql.*;

import domain.Kunde;

public class CprnummerAccess
{
  private static final String SELECT = "SELECT cprnummer, cprid FROM cprnummer WHERE cprid = ? OR cprnummer = ?";
  private static final String INSERT = "INSERT INTO cprnummer(cprnummer) VALUES(?)";
//  private static final String UPDATE = "UPDATE cprnummer SET cprnummer = ? WHERE cprid = ?";
  private static final String DELETE = "DELETE FROM cprnummer WHERE cprid = ?";
  
  public CprnummerAccess()
  {
    
  }
  
  /*
   * Create
   */
  public void createCprnummer( Kunde kunde ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      createCprnummer( connection, kunde );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void createCprnummer( Connection connection, Kunde kunde ) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    KundeAccess ka = new KundeAccess();
    try
    {
      statement = connection.prepareStatement( INSERT, PreparedStatement.RETURN_GENERATED_KEYS );
      statement.setString( 1, kunde.getCprnummer() );
      statement.execute();
      resultset = statement.getGeneratedKeys();
      if ( resultset.next() )
      {
        kunde.setCprid( resultset.getInt( 1 ) );
        ka.createKunde( connection, kunde );
      }
      
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
   * Read
   */
  public String readCprnummer( int cprid ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return readCprnummer( connection, cprid );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
 
  public String readCprnummer( Connection connection, int cprid ) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;    
    try
    {
      statement = connection.prepareStatement( SELECT );
      statement.setInt( 1, cprid );
      resultset = statement.executeQuery();
      String cprnummer = new String();
      while ( resultset.next() )
      {
      cprnummer = resultset.getString( "cprnummer" );
      }
      return cprnummer;
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }

  public Kunde readCprnummer( String cprnummer ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return readCprnummer( connection, cprnummer );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
//NEDENSTÅENDE ER IKKE FÆRDIG!!!  
  public Kunde readCprnummer( Connection connection, String cprnummer ) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;  
    Kunde kunde = null;
//    KundeAccess ka = new KundeAccess();
    try
    {
      statement = connection.prepareStatement( SELECT );
      statement.setString( 1, cprnummer );
      resultset = statement.executeQuery();
      kunde = new Kunde();
      kunde.setCprnummer( cprnummer );
      while ( resultset.next() )
      {
      kunde.setCprid( resultset.getInt( "cprid" ));
      }
      return kunde;
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  

  // /*
  // * Update
  // */
  // Update burde ikke være nødvendigt for Cprnummer (Idet at man ikke kan
  // skifte det).
  
  // public void updateCprnummer( Kunde kunde ) throws SQLException
  // {
  // Connection connection = null;
  // try
  // {
  // connection = new DbConnection().getConnection();
  // updateCprnummer( connection, kunde );
  // }
  // finally
  // {
  // if ( connection != null )
  // {
  // connection.close();
  // }
  // }
  // }
  //
  // public void updateCprnummer( Connection connection, Kunde kunde ) throws
  // SQLException
  // {
  // PreparedStatement statement = null;
  // try
  // {
  // statement = connection.prepareStatement( UPDATE );
  // statement.setString( 1, kunde.getCprnummer() );
  // statement.execute();
  //
  // }
  // finally
  // {
  // if ( statement != null )
  // {
  // statement.close();
  // }
  // }
  // }
  
  
  /*
   * Delete
   */
  public void deleteCprnummer( int cprid ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      deleteCprnummer( connection, cprid );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void deleteCprnummer( Connection connection, int cprid ) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( DELETE );
      statement.setInt( 1, cprid );
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
