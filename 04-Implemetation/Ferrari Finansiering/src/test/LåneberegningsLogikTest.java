package test;

import logic.*;
import domain.*;

public class LåneberegningsLogikTest
{
  public static void main( String[] argv ) 
  {
  LåneberegningsLogik lbl = new LåneberegningsLogik();
  Finansieringsaftale aftale = new Finansieringsaftale();
  aftale.setAfviklingsperiode( 36 );
  aftale.setBeløb( 1000000 );
  aftale.setUdbetaling( 500000 );
  aftale.setEkstraomkostninger( 100000 );
  
  String placering = "";
  
  CsvLogik csvl = new CsvLogik();
  csvl.writeCsvFile( lbl.beregnTilbud( "C", aftale ), "C:/Users/Dennis/Documents", "TestCSV" );
  lbl.beregnTilbud( "C", aftale );
  
//  System.out.println( lbl.beregnRente( "C", aftale ) );
  }
}
