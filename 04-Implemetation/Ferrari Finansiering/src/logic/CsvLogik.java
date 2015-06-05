package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
  private double restgæld;
  private double rentebeløb = 0;
  
  public void writeCsvFile(Finansieringsaftale aftale, String placering, String titel )
  {
    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter(new File(placering, titel)));
      bw.write( aftaleString );
      bw.newLine();
      bw.write( format(aftale) );
      bw.newLine();
      bw.newLine();
      bw.write( låneplanString );
      bw.newLine();
      
      restgæld = aftale.getBeløb();
      for(int i=0; i<=aftale.getAfviklingsperiode(); i++)
      {
      bw.write( betalingsplan(i, aftale) );
      bw.newLine();
      }
      
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
  
  /*
   * Istedet for kunde-ID skal ændres til navn og cpr. Sælger-ID skal ændres til navn.
   */
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
    aString.append( afrunding(aftale.getAfdragsbeløb()) );
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
    aString.append( afrunding(aftale.getÅop() ));
    aString.append( LINE_SEPARATOR );
    
    return aString.toString();
  }
  
  
  /*
   * Ikke kigget efter for fejl
   */
  private String betalingsplan(int i, Finansieringsaftale aftale)
  {
    StringBuilder bpString = new StringBuilder();
    
      bpString.append( i );
      bpString.append( DELIMITER );
      bpString.append( i/12 );
      bpString.append( DELIMITER );
      if(i==0)
      {
        bpString.append( 0.0 );
      }
      else
      {
        bpString.append( afrunding(aftale.getAfdragsbeløb()) );
      }
      bpString.append( DELIMITER );
      bpString.append( afrunding(rentebeløb) );
      bpString.append( DELIMITER );
      if(i==0)
      {
        bpString.append( 0.0 );
      }
      else
      {
        bpString.append( afrunding(aftale.getAfdragsbeløb() - rentebeløb)  );
      }
      bpString.append( DELIMITER );
      bpString.append( afrunding(restgæld) );
      bpString.append( LINE_SEPARATOR );
      
      rentebeløb = (restgæld * ((aftale.getRente()/100)/12));
      restgæld = restgæld - (aftale.getAfdragsbeløb() - rentebeløb );
    
    return bpString.toString();
  }
  
  private double afrunding(double d)
  {
    d = Math.round(d * 100);
    d = d/100;
    
    return d;
  }
  
}
