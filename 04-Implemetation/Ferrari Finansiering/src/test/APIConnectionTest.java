package test;

import logic.L�neberegningsLogik;

public class APIConnectionTest
{
  public static void main( String[] argv ) 
  {
    
    /*
     *  Test af Forbindelse til RKI       PASSED (Selvom retur-v�rdien virker ulogisk)!
     */
    L�neberegningsLogik lbl = new L�neberegningsLogik();
    System.out.println( lbl.getKreditV�rdighed( "" ) );
    
    
    /*
     * Test af Forbindelse til bank
     */
//    L�neberegningsLogik lbl = new L�neberegningsLogik();
//    System.out.println( lbl.getRente());
    
  }
}
