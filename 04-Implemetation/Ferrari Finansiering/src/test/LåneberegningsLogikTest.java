package test;

import logic.CsvLogik;
import logic.LåneberegningsLogik;
import domain.Finansieringsaftale;

public class LåneberegningsLogikTest
{
  public static void main( String[] argv ) 
  {
  LåneberegningsLogik lbl = new LåneberegningsLogik();
  Finansieringsaftale aftale = new Finansieringsaftale();
  aftale.setAfviklingsperiode( 24 );
  aftale.setBeløb( 1000000 );
  aftale.setUdbetaling( 0 );
  aftale.setEkstraomkostninger( 0 );
  
  CsvLogik csvl = new CsvLogik();
  csvl.writeCsvFile( lbl.beregnTilbud( "A", aftale ), "C:/Users/Dennis/Documents", "TestCSV" );
//  lbl.beregnTilbud( "C", aftale );
  
//  System.out.println( lbl.beregnRente( "C", aftale ) );
  }
}
