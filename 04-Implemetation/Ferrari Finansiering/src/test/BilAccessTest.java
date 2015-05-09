package test;

import java.sql.SQLException;
import logic.BilLogik;
import domain.Bil;


public class BilAccessTest
{
  public static void main( String[] args ) throws SQLException
  {
    
    /*
     * Test af createBil     PASSED
     */
    Bil bil = new Bil();
    
    bil.setChassisnummer( "a1b23n4567mk98" );
    bil.setRegistreringsnummer( "aa12345" );
    bil.setPris( 1000000 );
    bil.setModel( "Ascari" );
    bil.setÅrgang( "2005" );
    bil.setBemærkninger( "Prototype" );
    
    BilLogik bl = new BilLogik();
    bl.createBil( bil );
    
    
    /*
     * Test af readBil      PASSED
     */
//    BilLogik bl = new BilLogik();
//    System.out.println(bl.readBil( "a1b23n4567mk98" ).toString());
    
    
    /*
     * Test af updateBil     PASSED
     */
//  Bil bil = new Bil();
//  
//  bil.setChassisnummer( "a1b23n4567mk98" );
//  bil.setRegistreringsnummer( "ab" );
//  bil.setPris( 1000000 );
//  bil.setModel( "Ascari" );
//  bil.setÅrgang( "2005" );
//  bil.setBemærkninger( "Prototype" );
//  
//  BilLogik bl = new BilLogik();
//  bl.updateBil( bil );
    
    
    /*
     * Test af deleteBil      PASSED
     */
//  BilLogik bl = new BilLogik();
//  bl.deleteBil( "a1b23n4567mk98" );
    
  }
  
}
