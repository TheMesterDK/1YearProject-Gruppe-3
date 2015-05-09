package test;

import java.sql.SQLException;
import dataAccess.SælgerAccess;
import logic.SælgerLogik;
import domain.Sælger;

public class SælgerAccessTest
{
  public static void main( String[] args ) throws SQLException
  {
    /*
     * Test af createSælger     PASSED
     */
    Sælger sælger = new Sælger();
    sælger.setSælgernavn( "Ane Akselsen" );
    SælgerLogik sl = new SælgerLogik();
    sl.createSælger( sælger );
    
    
    /*
     * Test af readSælger       PASSED
     */
//    SælgerLogik sl = new SælgerLogik();
//    System.out.println(sl.readSælger( 1 ).toString());
    
    
    /*
     * Test af updateSælger     PASSED
     */
//  Sælger sælger = new Sælger();
//  sælger.setSælgernavn( "Anne Akselsen" );
//  sælger.setSælgerid( 1 );
//  SælgerLogik sl = new SælgerLogik();
//  sl.updateSælger( sælger );
    
    
    /*
     * Test af deleteSælger       PASSED
     */
//  SælgerLogik sl = new SælgerLogik();
//  sl.deleteSælger( 1 );
    
    
    
    
  }
  
}
