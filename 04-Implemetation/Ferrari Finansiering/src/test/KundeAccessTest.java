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
//     * Test createCprnummer (Og derigennem createKunde).    PASSED
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
     * test af readkunde      PASSED
     */
////    KundeAccess ka = new KundeAccess();
//    KundeLogik kl = new KundeLogik();
//    System.out.println(kl.readKunde( 18 ).toString());

    
    /*
     * test af updatekunde    PASSED
     */
//  Kunde kunde = new Kunde();
//  kunde.setCprid( 18 );
//  kunde.setCprnummer( "0406841545" );
//  kunde.setNavn( "Arne" );
//  kunde.setAdresse( "Aastræde 12" );
//  kunde.setPostnummer( "8660" );
//  kunde.setTelefonnummer( "87654321" );
//  kunde.setEmail( "Arne@Aastræde.dk" );
//  kunde.setKommentar( "Problem-Kunde" );
//
//  KundeLogik kl = new KundeLogik();
//  kl.updateKunde( kunde );
  
  
  /*
   * Test af deleteKunde        PASSED
   */
//  KundeLogik kl = new KundeLogik();
//  kl.deleteKunde( 18 );
  
  
    
    
    
  }
  
}
