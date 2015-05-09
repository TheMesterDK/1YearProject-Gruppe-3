package dataAccess;

import java.sql.*;

import domain.Bil;


public class BilAccess
{
  private static final String SELECT = "SELECT registreringsnummer, pris, model, �rgang, bem�rkninger FROM bil WHERE chassisnummer = ?";
//  private static final String SELECT_MANY = "SELECT registreringsnummer, pris, model, �rgang, bem�rkninger FROM bil WHERE ";
  private static final String INSERT = "INSERT INTO bil(chassisnummer, registreringsnummer, pris, model, �rgang, cprid, bem�rkninger) VALUES (?, ?, ?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE bil SET registreringsnummer = ?, pris = ?, model = ?, �rgang = ?, bem�rkninger = ? WHERE chassisnummer = ?";
  private static final String DELETE = "DELETE FROM bil WHERE chassisnummer = ?";
  
  
  public BilAccess()
  {
    
  }
  
  
  /*
   * Create
   */
  public void createBil(Bil bil) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      createBil( connection, bil );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void createBil(Connection connection, Bil bil) throws SQLException
  {
    PreparedStatement statement = null;
//    ResultSet resultset = null;
    try
    {
      statement = connection.prepareStatement( INSERT );
      statement.setString( 1, bil.getChassisnummer() );
      statement.setString( 2, bil.getRegistreringsnummer() );
      statement.setDouble( 3, bil.getPris() );
      statement.setString( 4, bil.getModel() );
      statement.setString( 5, bil.get�rgang() );
      statement.setInt( 6, bil.getCprid() );
      statement.setString( 7, bil.getBem�rkninger() );
      statement.execute();
      connection.commit();
    }
    finally
    {
//      if ( resultset != null )
//      {
//        resultset.close();
//        System.out.println("Bil, resultset close");
//      }
      if ( statement != null )
      {
        statement.close();
//        System.out.println("Bil, statement close");
      }
    }
    
  }
  
  
  /*
   * Read
   */
  public Bil readBil(String chassisnummer) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return readBil( connection, chassisnummer );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public Bil readBil(Connection connection, String chassisnummer) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    Bil bil = null;
    try
    {
      statement = connection.prepareStatement( SELECT );
      statement.setString( 1, chassisnummer );
      resultset = statement.executeQuery();
      bil = new Bil();
      while ( resultset.next() )
      {
      bil.setRegistreringsnummer( resultset.getString( "registreringsnummer" ) );
      bil.setPris( resultset.getDouble( "pris" ) );
      bil.setModel( resultset.getString( "model" ) );
      bil.set�rgang( resultset.getString( "�rgang" ) );
      bil.setBem�rkninger( resultset.getString( "bem�rkninger" ) );
      }
      return bil;
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
  public void updateBil(Bil bil) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      updateBil( connection, bil );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  

  
  public void updateBil(Connection connection, Bil bil) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( UPDATE );
      statement.setString( 1, bil.getChassisnummer() );
      statement.setString( 2, bil.getRegistreringsnummer() );
      statement.setDouble( 3, bil.getPris() );
      statement.setString( 4, bil.getModel() );
      statement.setString( 5, bil.get�rgang() );
      statement.setInt( 6, bil.getCprid() );
      statement.setString( 7, bil.getBem�rkninger() );
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
    public void deleteBil(String chassisnummer) throws SQLException
    {
      Connection connection = null;
      try
      {
        connection = new DbConnection().getConnection();
        deleteBil( connection, chassisnummer );
      }
      finally
      {
        if ( connection != null )
        {
          connection.close();
        }
      }
    }
    
    public void deleteBil(Connection connection, String chassisnummer) throws SQLException
    {
      PreparedStatement statement = null;
      try
      {
        statement = connection.prepareStatement( DELETE );
        statement.setString( 1, chassisnummer );
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
