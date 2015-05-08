package dataAccess;

import java.sql.*;
import java.util.*;

import domain.Kunde;


public class KundeAccess
{
  private static final String SELECT = "SELECT navn, adresse, telefonnummer, postnummer, email, kommentar FROM kunde WHERE cprid = ?";
//  private static final String SELECT_MANY = "SELECT navn, adresse, telefonnummer, postnummer, email, kommentar FROM kunde WHERE cprid = ? OR navn = ? OR adresse = ? OR telefonnummer = ? OR email = ?";
  private static final String INSERT = "INSERT INTO kunde(cprid, navn, adresse, telefonnummer, postnummer, email, kommentar) VALUES (?, ?, ?, ?, ?, ?, ?)"; //Skal cprid, medsendes her.?
  private static final String UPDATE = "UPDATE kunde SET navn = ?, adresse = ?, telefonnummer = ?, postnummer = ?, email = ?, kommentar = ? WHERE cprid = ?";
  private static final String DELETE = "DELETE FROM kunde WHERE cprid = ?";
  
  
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
        System.out.println("kundeacces:");
        System.out.println("Statement er lukket");
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
