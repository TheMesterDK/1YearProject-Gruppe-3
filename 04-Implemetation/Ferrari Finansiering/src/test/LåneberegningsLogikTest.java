package test;

import logic.CsvLogik;
import logic.L�neberegningsLogik;
import domain.Finansieringsaftale;

public class L�neberegningsLogikTest
{
  public static void main( String[] argv )
  {
    L�neberegningsLogik lbl = new L�neberegningsLogik();
    Finansieringsaftale aftale = new Finansieringsaftale();
    aftale.setAfviklingsperiode( 36 );
    aftale.setBel�b( 1000000 );
    aftale.setUdbetaling( 100000 );
    aftale.setEkstraomkostninger( 0 );
    
    CsvLogik csvl = new CsvLogik();
    csvl.writeCsvFile( lbl.beregnTilbud( "A", aftale ), "C:/Users/Dennis/Documents", "TestCSV" );
    // lbl.beregnTilbud( "C", aftale );
    
    // System.out.println( lbl.beregnRente( "C", aftale ) );
  }
}
