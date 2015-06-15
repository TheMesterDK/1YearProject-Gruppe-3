package test;

import logic.LåneberegningsLogik;

public class APIConnectionTest
{
  public static void main( String[] argv )
  {
    
    /*
     * Test af Forbindelse til RKI PASSED (Selvom retur-værdien virker ulogisk)!
     */
    LåneberegningsLogik lbl = new LåneberegningsLogik();
    System.out.println( lbl.getKreditVærdighed( "" ) );
    
    /*
     * Test af Forbindelse til bank
     */
    // LåneberegningsLogik lbl = new LåneberegningsLogik();
    // System.out.println( lbl.getRente());
    
  }
}
