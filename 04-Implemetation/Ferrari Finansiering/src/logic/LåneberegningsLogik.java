package logic;

import domain.*;
import dataAccess.*;


public class LåneberegningsLogik
{
  private double rente;
  private double totalbeløb;
  
  
  public String getKreditVærdighed(String cprnummer)
  {
    APIConnection ac = new APIConnection();
    return ac.getKreditVærdighed( cprnummer );
  }
  
  
  public double getRente(String kreditværdighed, Finansieringsaftale aftale)
  {
//  Måske skal bankens rente først påregnes efter de andre beregninger    
//    APIConnection ac = new APIConnection();
//    rente = ac.getRente();
    
    if(kreditværdighed == "A")
    {
      rente += 1;
    }
    else if(kreditværdighed == "B")
    {
      rente += 2;
    }
    else if(kreditværdighed == "C")
    {
      rente += 3;
    }
    
    if(aftale.getAfviklingsperiode() > 36)
    {
      rente += 1;
    }
    
    
    
    /*
     * Nedenstående renteformel er (MÅSKE) ikke færdig endnu
     */
    if(aftale.getAfdragsbeløb() == 0 )
    {
      
      double afdragsbeløb = (aftale.getBeløb() - aftale.getUdbetaling()) * ((rente/100) / (1- Math.pow((1+(rente/100)), -(rente/100))));
      aftale.setAfdragsbeløb( afdragsbeløb );    
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
