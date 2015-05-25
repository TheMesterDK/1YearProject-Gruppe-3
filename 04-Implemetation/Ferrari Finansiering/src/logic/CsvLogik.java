package logic;

import java.io.*;
import domain.Finansieringsaftale;

/*
 * IKKE F�RDIG. MANGLER AT BESTEMME R�KKEF�LGEN P� OPLYSNINGERNE, OG AT TESTE...
 */
public class CsvLogik
{
  private static final String DELIMITER = ",";
  private static final String LINE_SEPARATOR = "\n";
  private static final String OVERSKRIFT = "Finansieringsaftale-id,Cpr-nummer,Navn";
  
  public void writeCsvFile(Finansieringsaftale aftale, String placering )
  {
    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter(placering));
      bw.write( OVERSKRIFT );
      bw.newLine();
      bw.write( format(aftale) );
      bw.flush();
      bw.close();
    }
    catch ( IOException e )
    {
      System.out.println( "Error in CsvFileWriter !!!" );
      e.printStackTrace();
    }

    System.out.println( "CSV file was created successfully !!!" );
    
  }
  
  
  private String format(Finansieringsaftale aftale)
  {
    StringBuilder aftaleString = new StringBuilder();
    aftaleString.append( aftale.getAftaleid() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getBel�b() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getUdbetaling() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getRente() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getAfviklingsperiode() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getOprettelsesdato() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getF�rsteafbetalingdato() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getSidsteafbetalingdato() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getAfdragsbel�b() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getSidsteafdragsbel�b() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getS�lgerid() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getChassisnummer() );
    aftaleString.append( DELIMITER );
    aftaleString.append( aftale.getCprid() );
    aftaleString.append( LINE_SEPARATOR );
    
    return aftaleString.toString();
  }
  
}
