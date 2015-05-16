package test;

import java.sql.SQLException;
import java.util.List;

import domain.Kunde;
import exceptions.*;
import dataAccess.*;
import logic.KundeLogik;

public class KundeAccessTest
{
  
  public static void main( String[] args ) throws SQLException, KundeAllreadyExist
  {
    /*
     * Test createCprnummer (Og derigennem createKunde).    PASSED
     */
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
//    
//    
//    kunde = new Kunde();
//    kunde.setCprnummer( "0408841545" );
//    kunde.setNavn( "Bent" );
//    kunde.setAdresse( "Bredgade 5" );
//    kunde.setPostnummer( "8660" );
//    kunde.setTelefonnummer( "23456789" );
//    kunde.setEmail( "Bent@Bredgade.dk" );
//    kunde.setKommentar( "Dårlig kunde" );
//    
//    kl = new KundeLogik();
//    kl.createKunde( kunde );
//    
//    
//    kunde = new Kunde();
//    kunde.setCprnummer( "0406921545" );
//    kunde.setNavn( "Charlie" );
//    kunde.setAdresse( "Chagade 3" );
//    kunde.setPostnummer( "8600" );
//    kunde.setTelefonnummer( "34567890" );
//    kunde.setEmail( "Charlie@Chagade.dk" );
//    kunde.setKommentar( "Kunde" );
//    
//    kl = new KundeLogik();
//    kl.createKunde( kunde );
    
    
    /*
     * test af readkunde      PASSED
     */
////    KundeAccess ka = new KundeAccess();
//    KundeLogik kl = new KundeLogik();
//    System.out.println(kl.readKunde( 19 ).toString());
    
    
    /*
     * Test af ListKunder
     */
    
    KundeLogik kl = new KundeLogik();
    List<Kunde> searchlist = kl.listKunder( "cprid", "22" );
    for(int i= 0; i>searchlist.size(); i++)
    {
      System.out.println(i+ " " + searchlist.get( i ).toString());
    }
    
//    System.out.println(kl.readKunde( 19 ).toString());
//        public List<Kunde> listKunder(String Adresse, String gade)

    
    /*
     * test af updatekunde    PASSED
     */
//  Kunde kunde = new Kunde();
//  kunde.setCprid( 19 );
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
//  kl.deleteKunde( 19 );
  
  
    
    
    
  }
  
}
