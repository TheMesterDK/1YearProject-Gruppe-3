package test;

import java.sql.SQLException;

public class FinansieringsaftaleAccessTest
{
  
  public static void main( String[] args ) throws SQLException
  {
    
    /*
     * Test af createFinansieringsaftale PASSED
     */
    // Finansieringsaftale aftale = new Finansieringsaftale();
    //
    // aftale.setBeløb( 1000000 );
    // aftale.setUdbetaling( 100000 );
    // aftale.setRente( 5.8 );
    // aftale.setAfviklingsperiode( 36 );
    // aftale.setOprettelsesdato( "22-07-2015" );
    // aftale.setSælgerid( 2 );
    // aftale.setChassisnummer( "a1b23n4567mk98" );
    // aftale.setCprid( 20 );
    //
    // FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
    // fl.createFinansieringsaftale( aftale );
    //
    //
    // aftale = new Finansieringsaftale();
    //
    // aftale.setBeløb( 2000000 );
    // aftale.setUdbetaling( 200000 );
    // aftale.setRente( 6.8 );
    // aftale.setAfviklingsperiode( 36 );
    // aftale.setOprettelsesdato( "22-07-2015" );
    // aftale.setSælgerid( 2 );
    // aftale.setChassisnummer( "b1b23n4567mk98" );
    // aftale.setCprid( 21 );
    //
    // fl = new FinansieringsaftaleLogik();
    // fl.createFinansieringsaftale( aftale );
    //
    //
    // aftale = new Finansieringsaftale();
    //
    // aftale.setBeløb( 3000000 );
    // aftale.setUdbetaling( 300000 );
    // aftale.setRente( 7.8 );
    // aftale.setAfviklingsperiode( 36 );
    // aftale.setOprettelsesdato( "22-07-2015" );
    // aftale.setSælgerid( 2 );
    // aftale.setChassisnummer( "c1b23n4567mk98" );
    // aftale.setCprid( 22 );
    //
    // fl = new FinansieringsaftaleLogik();
    // fl.createFinansieringsaftale( aftale );
    
    /*
     * Test af readFinansieringsaftale PASSED
     */
    // FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
    // System.out.println(fl.readFinansieringsaftale(0).toString());
    
    /*
     * Test af listFinansieringsaftale PASSED
     */
    // FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
    // List<Finansieringsaftale> searchlist = fl.listFinansieringsaftaler(
    // "aftaleid", "" );
    // for(int i= 0; i<searchlist.size(); i++)
    // {
    // System.out.println(i+ " " + searchlist.get( i ).toString());
    // }
    
    /*
     * Test af updateFinansieringsaftale PASSED
     */
    // Finansieringsaftale aftale = new Finansieringsaftale();
    //
    // aftale.setBeløb( 1000000 );
    // aftale.setUdbetaling( 100000 );
    // aftale.setRente( 6.0 );
    // aftale.setAfviklingsperiode( 48 );
    // aftale.setOprettelsesdato( "22-06-2015" );
    // aftale.setSælgerid( 1 );
    // aftale.setChassisnummer( "a1b23n4567mk98" );
    // aftale.setCprid( 19 );
    // aftale.setAftaleid( 0 );
    //
    // FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
    // fl.updateFinansieringsaftale( aftale );
    
    /*
     * Test af deleteFinansieringsaftale PASSED
     */
    // FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
    // fl.deleteFinansieringsaftale(0);
    
  }
  
}
