package test;

import java.sql.SQLException;

import domain.Kunde;
import exceptions.*;
import dataAccess.*;
import logic.KundeLogik;

public class KundeAccessTest
{
  
  public static void main( String[] args ) throws SQLException, KundeAllreadyExist
  {
//    /*
//     * Test createCprnummer (Og derigennem createKunde).
//     */
//    Kunde kunde = new Kunde();
//    kunde.setCprnummer( "0406841545" );
//    kunde.setNavn( "Anders" );
//    kunde.setAdresse( "Aagade 35" );
//    kunde.setPostnummer( "8600" );
//    kunde.setTelefonnummer( "12345678" );
//    kunde.setEmail( "Anders@Aagade.dk" );
//    kunde.setKommentar( "God Kunde" );
//    
////    CprnummerAccess cpraccess = new CprnummerAccess();   
////    cpraccess.createCprnummer(kunde);
//
//    KundeLogik kl = new KundeLogik();
//    kl.createKunde( kunde );
    
    /*
     * test af readkunde
     */
//    KundeAccess ka = new KundeAccess();
    KundeLogik kl = new KundeLogik();
    System.out.println(kl.readKunde( 18 ).toString());

    
    
    
  }
  
}
