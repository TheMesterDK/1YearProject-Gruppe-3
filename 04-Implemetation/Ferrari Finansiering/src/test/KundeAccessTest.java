package test;

import java.sql.SQLException;

import domain.Kunde;
import dataAccess.CprnummerAccess;
import dataAccess.KundeAccess;

public class KundeAccessTest
{
  
  public static void main( String[] args ) throws SQLException
  {
    Kunde kunde = new Kunde();
    kunde.setCprnummer( "0406841545" );
    kunde.setNavn( "Anders" );
    kunde.setAdresse( "Aagade 35" );
    kunde.setPostnummer( "8600" );
    kunde.setTelefonnummer( "12345678" );
    kunde.setEmail( "Anders@Aagade.dk" );
    kunde.setKommentar( "God Kunde" );
    
    CprnummerAccess cpraccess = new CprnummerAccess();
    
    cpraccess.createCprnummer(kunde);

    
    
  }
  
}
