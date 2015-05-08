package dataAccess;

import java.sql.*;


import domain.Kunde;


public class KundeAccess
{
  private static final String SELECT = "SELECT navn, adresse, telefonnummer, postnummer, email, kommentar FROM kunde WHERE cprid = ?";
  //  private static final String SELECT_MANY = "SELECT navn, adresse, telefonnummer, postnummer, email, kommentar FROM kunde WHERE cprid = ? OR navn = ? OR adresse = ? OR telefonnummer = ? OR email = ?";
  private static final String INSERT = "INSERT INTO kunde(cprid, navn, adresse, telefonnummer, postnummer, email, kommentar) VALUES (?, ?, ?, ?, ?, ?, ?)"; //Skal cprid, medsendes her.?
  private static final String UPDATE = "UPDATE kunde SET navn = ?, adresse = ?, telefonnummer = ?, postnummer = ?, email = ?, kommentar = ? WHERE cprid = ?";
//  private static final String DELETE = "DELETE FROM kunde WHERE cprid = ?";
  
  
  public KundeAccess()
  {
    
  }
  
  
  /*
   * Create
   */
  public void createKunde(Kunde kunde) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      createKunde( connection, kunde );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void createKunde(Connection connection, Kunde kunde) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    //    CprnummerAccess cpraccess = new CprnummerAccess();
    //    int cprid =0;
    try
    {
      statement = connection.prepareStatement( INSERT );
      statement.setInt( 1, kunde.getCprid() );
      statement.setString( 2, kunde.getNavn() );
      statement.setString( 3, kunde.getAdresse() );
      statement.setString( 4, kunde.getTelefonnummer() );
      statement.setString( 5, kunde.getPostnummer() );
      statement.setString( 6, kunde.getEmail() );
      statement.setString( 7, kunde.getKommentar() );
      statement.execute();
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
  public Kunde readKunde(int cprid) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return readKunde( connection, cprid );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public Kunde readKunde(Connection connection, int cprid) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    Kunde kunde = null;
    try
    {
      statement = connection.prepareStatement( SELECT );
      statement.setInt( 1, cprid );
      resultset = statement.executeQuery();
      kunde = new Kunde();
      kunde.setCprid( cprid );
      kunde.setNavn( resultset.getString( "navn" ) );
      kunde.setAdresse( resultset.getString( "adresse" ) );
      kunde.setPostnummer( resultset.getString( "postnummer" ) );
      kunde.setTelefonnummer( resultset.getString( "telefonnummer" ) );
      kunde.setEmail( resultset.getString( "email" ) );
      kunde.setKommentar( resultset.getString( "kommentar" ) );  
      return kunde;
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
  public void updateKunde(Kunde kunde) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      updateKunde( connection, kunde );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
  
  public void updateKunde(Connection connection, Kunde kunde) throws SQLException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement( UPDATE );
      statement.setString( 1, kunde.getNavn() );
      statement.setString( 2, kunde.getAdresse() );
      statement.setString( 3, kunde.getTelefonnummer() );
      statement.setString( 4, kunde.getPostnummer() );
      statement.setString( 5, kunde.getEmail() );
      statement.setString( 6, kunde.getKommentar() );
      statement.setInt( 7, kunde.getCprid() );
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
  
  
  //  /*
  //   * Delete
  //   */  
  //              DeleteKunde er ikke n�dvendig idet at et delete p� cprid i CprnummerAccess
  //              vil cascade og delete tilh�rende kunde.
  //  
  //  public void deleteKunde(Kunde kunde) throws SQLException
  //  {
  //    Connection connection = null;
  //    try
  //    {
  //      connection = new DbConnection().getConnection();
  //      createKunde( connection, kunde );
  //    }
  //    finally
  //    {
  //      if ( connection != null )
  //      {
  //        connection.close();
  //      }
  //    }
  //  }


}
