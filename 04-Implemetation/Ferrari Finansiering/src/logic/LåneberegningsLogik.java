package logic;

import domain.*;
import dataAccess.*;


public class L�neberegningsLogik
{
  private double rente;
  private double totalbel�b;
  
  
  public String getKreditV�rdighed(String cprnummer)
  {
    APIConnection ac = new APIConnection();
    return ac.getKreditV�rdighed( cprnummer );
  }
  
  
  public double getRente(String kreditv�rdighed, Finansieringsaftale aftale)
  {
//  M�ske skal bankens rente f�rst p�regnes efter de andre beregninger    
//    APIConnection ac = new APIConnection();
//    rente = ac.getRente();
    
    if(kreditv�rdighed == "A")
    {
      rente += 1;
    }
    else if(kreditv�rdighed == "B")
    {
      rente += 2;
    }
    else if(kreditv�rdighed == "C")
    {
      rente += 3;
    }
    
    if(aftale.getAfviklingsperiode() > 36)
    {
      rente += 1;
    }
    
    
    
    /*
     * Nedenst�ende renteformel er (M�SKE) ikke f�rdig endnu
     */
    if(aftale.getAfdragsbel�b() == 0 )
    {
      
      double afdragsbel�b = (aftale.getBel�b() - aftale.getUdbetaling()) * ((rente/100) / (1- Math.pow((1+(rente/100)), -(rente/100))));
      aftale.setAfdragsbel�b( afdragsbel�b );    
    }
    /*
     * 
     */
    
//    if((pris/udbetaling) > 2)
//    {
//      rente += 1;
//    }
    
    return rente;
  }
  
  
}
