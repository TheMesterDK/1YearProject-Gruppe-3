package dataAccess;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Kunde;


public class KundeAccess
{
  private static final String SELECTCPRNUMMER = "SELECT cprnummer, cprid FROM cprnummer WHERE cprid = ? OR cprnummer = ?";
  private static final String SELECTCPRKUNDE = "SELECT cprnummer, cprnummer.cprid, navn, adresse, telefonnummer, postnummer, email, kommentar FROM cprnummer INNER JOIN kunde ON cprnummer.cprid = kunde.cprid WHERE cprnummer = ?";
  private static final String SELECTKUNDE = "SELECT navn, adresse, telefonnummer, postnummer, email, kommentar FROM kunde WHERE cprid = ?";
  private static final String INSERTCPRNUMMER = "INSERT INTO cprnummer(cprnummer) VALUES(?)";
  private static final String INSERTKUNDE = "INSERT INTO kunde(cprid, navn, adresse, telefonnummer, postnummer, email, kommentar) VALUES (?, ?, ?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE kunde SET navn = ?, adresse = ?, telefonnummer = ?, postnummer = ?, email = ?, kommentar = ? WHERE cprid = ?";
  private static final String DELETE = "DELETE FROM cprnummer WHERE cprid = ?";
  
  
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
    PreparedStatement statement1 = null;
    ResultSet resultset = null;
    try
    {
      statement1 = connection.prepareStatement( INSERTCPRNUMMER, PreparedStatement.RETURN_GENERATED_KEYS );
      statement1.setString( 1, kunde.getCprnummer() );
      statement1.execute();
      resultset = statement1.getGeneratedKeys();
      if ( resultset.next() )
      {
        kunde.setCprid( resultset.getInt( 1 ) );
        statement = connection.prepareStatement( INSERTKUNDE );
        statement.setInt( 1, kunde.getCprid() );
        statement.setString( 2, kunde.getNavn() );
        statement.setString( 3, kunde.getAdresse() );
        statement.setString( 4, kunde.getTelefonnummer() );
        statement.setString( 5, kunde.getPostnummer() );
        statement.setString( 6, kunde.getEmail() );
        statement.setString( 7, kunde.getKommentar() );
        statement.execute();
        connection.commit();
      }
      connection.commit();
      
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
      statement = connection.prepareStatement( SELECTCPRNUMMER );
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

  public Kunde readKunde( String cprnummer ) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return readKunde( connection, cprnummer );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }

  public Kunde readKunde( Connection connection, String cprnummer ) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;  
    Kunde kunde = null;
    try
    {
      statement = connection.prepareStatement( SELECTCPRKUNDE );
      statement.setString( 1, cprnummer );
      resultset = statement.executeQuery();
      kunde = new Kunde();
      kunde.setCprnummer( cprnummer );
      while ( resultset.next() )
      {
      kunde.setCprid( resultset.getInt( "cprid" ));
      kunde.setNavn( resultset.getString( "navn" ) );
      kunde.setAdresse( resultset.getString( "adresse" ) );
      kunde.setPostnummer( resultset.getString( "postnummer" ) );
      kunde.setTelefonnummer( resultset.getString( "telefonnummer" ) );
      kunde.setEmail( resultset.getString( "email" ) );
      kunde.setKommentar( resultset.getString( "kommentar" ) );
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
      statement = connection.prepareStatement( SELECTKUNDE );
      statement.setInt( 1, cprid );
      resultset = statement.executeQuery();
      kunde = new Kunde();
      kunde.setCprid( cprid );
      while ( resultset.next() )
      {
      kunde.setNavn( resultset.getString( "navn" ) );
      kunde.setAdresse( resultset.getString( "adresse" ) );
      kunde.setPostnummer( resultset.getString( "postnummer" ) );
      kunde.setTelefonnummer( resultset.getString( "telefonnummer" ) );
      kunde.setEmail( resultset.getString( "email" ) );
      kunde.setKommentar( resultset.getString( "kommentar" ) );
      }
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
  
  
  public List<Kunde> listKunder(String searchitem, String search) throws SQLException
  {
    Connection connection = null;
    try
    {
      connection = new DbConnection().getConnection();
      return listKunder( connection, searchitem, search );
    }
    finally
    {
      if ( connection != null )
      {
        connection.close();
      }
    }
  }
 
  public List<Kunde> listKunder(Connection connection, String searchitem, String search) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    List<Kunde> list = new ArrayList<>();
    try
    {
      String SEARCH = "SELECT cprid ,navn, adresse, postnummer, telefonnummer, email, kommentar FROM kunde where " + searchitem + " LIKE ?";
      statement = connection.prepareStatement( SEARCH );
      statement.setString(1, "%" + search + "%");
      resultset = statement.executeQuery();
      while (resultset.next())
      {
        Kunde kunde = new Kunde();
        kunde.setCprid( resultset.getInt( "cprid" ) );
        kunde.setNavn( resultset.getString( "navn" ) );
        kunde.setAdresse( resultset.getString( "adresse" ) );
        kunde.setPostnummer( resultset.getString( "postnummer" ) );
        kunde.setTelefonnummer( resultset.getString( "telefonnummer" ) );
        kunde.setEmail( resultset.getString( "email" ) );
        kunde.setKommentar( resultset.getString( "kommentar" ) );
        list.add(kunde);
      }
      return list;
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
