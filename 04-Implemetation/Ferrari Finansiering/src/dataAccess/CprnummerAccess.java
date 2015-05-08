package dataAccess;

import java.sql.*;
import java.util.*;

import domain.Kunde;

public class CprnummerAccess
{
  private static final String SELECT = "SELECT cprnummer FROM cprnummer WHERE cprid = ?";
  // private static final String SELECT_MANY = "SELECT  FROM  WHERE ";
  private static final String INSERT = "INSERT INTO cprnummer(cprnummer) VALUES(?)";
  private static final String UPDATE = "UPDATE cprnummer SET cprnummer = ? WHERE cprid = ?";
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
        ka.createKunde( kunde );
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
  
  /*
   * Update
   */
  
  /*
   * Delete
   */
  
}
