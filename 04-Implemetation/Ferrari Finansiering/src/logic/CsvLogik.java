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
  private static final String aftaleString = "Aftale-ID,Cpr-ID,L�nebel�b,Udbetaling,Afdragsbel�b,Afviklingsperiode,Rente,Oprettelsesdato,F�rste_Betaling_Dato,S�lger-ID,Chassisnummer,�OP";
  private static final String l�neplanString = "Betaling,�r,Ydelse,Rentebel�b,G�ldsnedskrivning,Restg�ld";
  
  
  public void writeCsvFile(Finansieringsaftale aftale, String placering, String titel )
  {
    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter(new File(placering, titel)));
      bw.write( aftaleString );
      bw.newLine();
      bw.write( format(aftale) );
      bw.newLine();
      bw.write( l�neplanString );
      bw.newLine();
      bw.write( betalingsplan(aftale) );
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
    StringBuilder aString = new StringBuilder();
    aString.append( aftale.getAftaleid() );
    aString.append( DELIMITER );
    aString.append( aftale.getCprid() );
    aString.append( DELIMITER );
    aString.append( aftale.getBel�b() );
    aString.append( DELIMITER );
    aString.append( aftale.getUdbetaling() );
    aString.append( DELIMITER );
    aString.append( aftale.getAfdragsbel�b() );
    aString.append( DELIMITER );
    aString.append( aftale.getAfviklingsperiode() );
    aString.append( DELIMITER );
    aString.append( aftale.getRente() );
    aString.append( DELIMITER );
    aString.append( aftale.getOprettelsesdato() );
    aString.append( DELIMITER );
    aString.append( aftale.getF�rsteafbetalingdato() );
    aString.append( DELIMITER );
    aString.append( aftale.getS�lgerid() );
    aString.append( DELIMITER );
    aString.append( aftale.getChassisnummer() );
    aString.append( DELIMITER );
    aString.append( aftale.get�op() );
    aString.append( LINE_SEPARATOR );
    
    return aString.toString();
  }
  
  
  /*
   * IKKE TESTET
   */
  private String betalingsplan(Finansieringsaftale aftale)
  {
    double restg�ld = aftale.getBel�b();
    double rentebel�b = 0;
    StringBuilder bpString = new StringBuilder();
    for(int i=0; i<aftale.getAfviklingsperiode(); i++)
    {
      bpString.append( i );
      bpString.append( DELIMITER );
      bpString.append( i/12 );
      bpString.append( DELIMITER );
      bpString.append( aftale.getAfdragsbel�b() );
      bpString.append( DELIMITER );
      bpString.append( rentebel�b );
      bpString.append( DELIMITER );
      bpString.append( aftale.getAfdragsbel�b() - rentebel�b  );
      bpString.append( DELIMITER );
      bpString.append( restg�ld );
      bpString.append( LINE_SEPARATOR );
      
      rentebel�b = (restg�ld * ((aftale.getRente()/100)/12));
      restg�ld = restg�ld - (aftale.getAfdragsbel�b() - rentebel�b );
    }
    
    
    return bpString.toString();
  }
  
}
