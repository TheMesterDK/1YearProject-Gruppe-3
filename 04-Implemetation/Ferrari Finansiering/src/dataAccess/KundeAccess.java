package dataAccess;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
      connection.commit();
    }
    finally
    {
//      if ( resultset != null )
//      {
//        resultset.close();
//        System.out.println("Kunde, resultset close");
//      }
      if ( statement != null )
      {
        statement.close();
//        System.out.println("Kunde, statement close");
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
// NEDENSTÅENDE ER ENDNU IKKE TESTET!!!  
  public List<Kunde> listKunder(Connection connection, String searchitem, String search) throws SQLException
  {
    PreparedStatement statement = null;
    ResultSet resultset = null;
    List<Kunde> list = new ArrayList<>();
    CprnummerAccess cpraccess = new CprnummerAccess();
    try
    {
      String SEARCH = "SELECT * FROM kunde where " + searchitem + " LIKE ?";
      statement = connection.prepareStatement( SEARCH );
      statement.setString(1, "%" + search + "%");
      resultset = statement.executeQuery();
      while (resultset.next())
      {
        Kunde kunde = new Kunde();
        kunde.setCprid( resultset.getInt( "cprid" ) );
        kunde.setCprnummer( cpraccess.readCprnummer( connection, resultset.getInt( "cprid" ) ) );
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
  
  
  //  /*
  //   * Delete
  //   */  
  //              DeleteKunde er ikke nødvendig idet at et delete på cprid i CprnummerAccess
  //              vil cascade og delete tilhørende kunde.
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
