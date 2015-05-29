package logic;

import java.io.*;
import domain.Finansieringsaftale;

/*
 * IKKE FÆRDIG. MANGLER AT BESTEMME RÆKKEFØLGEN PÅ OPLYSNINGERNE, OG AT TESTE...
 */
public class CsvLogik
{
  private static final String DELIMITER = ",";
  private static final String LINE_SEPARATOR = "\n";
  private static final String aftaleString = "Aftale-ID,Cpr-ID,Lånebeløb,Udbetaling,Afdragsbeløb,Afviklingsperiode,Rente,Oprettelsesdato,Første_Betaling_Dato,Sælger-ID,Chassisnummer,ÅOP";
  private static final String låneplanString = "Betaling,År,Ydelse,Rentebeløb,Gældsnedskrivning,Restgæld";
  
  
  public void writeCsvFile(Finansieringsaftale aftale, String placering, String titel )
  {
    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter(new File(placering, titel)));
      bw.write( aftaleString );
      bw.newLine();
      bw.write( format(aftale) );
      bw.newLine();
      bw.write( låneplanString );
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
    aString.append( aftale.getBeløb() );
    aString.append( DELIMITER );
    aString.append( aftale.getUdbetaling() );
    aString.append( DELIMITER );
    aString.append( aftale.getAfdragsbeløb() );
    aString.append( DELIMITER );
    aString.append( aftale.getAfviklingsperiode() );
    aString.append( DELIMITER );
    aString.append( aftale.getRente() );
    aString.append( DELIMITER );
    aString.append( aftale.getOprettelsesdato() );
    aString.append( DELIMITER );
    aString.append( aftale.getFørsteafbetalingdato() );
    aString.append( DELIMITER );
    aString.append( aftale.getSælgerid() );
    aString.append( DELIMITER );
    aString.append( aftale.getChassisnummer() );
    aString.append( DELIMITER );
    aString.append( aftale.getÅop() );
    aString.append( LINE_SEPARATOR );
    
    return aString.toString();
  }
  
  
  /*
   * IKKE TESTET
   */
  private String betalingsplan(Finansieringsaftale aftale)
  {
    double restgæld = aftale.getBeløb();
    double rentebeløb = 0;
    StringBuilder bpString = new StringBuilder();
    for(int i=0; i<aftale.getAfviklingsperiode(); i++)
    {
      bpString.append( i );
      bpString.append( DELIMITER );
      bpString.append( i/12 );
      bpString.append( DELIMITER );
      bpString.append( aftale.getAfdragsbeløb() );
      bpString.append( DELIMITER );
      bpString.append( rentebeløb );
      bpString.append( DELIMITER );
      bpString.append( aftale.getAfdragsbeløb() - rentebeløb  );
      bpString.append( DELIMITER );
      bpString.append( restgæld );
      bpString.append( LINE_SEPARATOR );
      
      rentebeløb = (restgæld * ((aftale.getRente()/100)/12));
      restgæld = restgæld - (aftale.getAfdragsbeløb() - rentebeløb );
    }
    
    
    return bpString.toString();
  }
  
}
