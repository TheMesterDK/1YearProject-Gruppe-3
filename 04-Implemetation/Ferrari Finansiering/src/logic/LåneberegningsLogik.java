package logic;

import dataAccess.APIConnection;
import domain.Finansieringsaftale;


public class LåneberegningsLogik
{
  private double rente;
  
  
  public String getKreditVærdighed(String cprnummer)
  {
	  
    APIConnection ac = new APIConnection();
    return ac.getKreditVærdighed( cprnummer );
  }
  
  
  public Finansieringsaftale beregnTilbud(String kreditværdighed, Finansieringsaftale aftale)
  {
    aftale.setRente( beregnRente(kreditværdighed, aftale) );
    aftale.setAfdragsbeløb( beregnAfdragsbeløb(aftale) );
    aftale.setÅop( beregnÅOP(aftale) );
    
    return aftale;
  }
  
  
  private double beregnRente(String kreditværdighed, Finansieringsaftale aftale)
  {

    APIConnection ac = new APIConnection();
    rente = ac.getRente();
    
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
    
    
    if((aftale.getBeløb()/aftale.getUdbetaling()) > 2)
    {
      rente += 1;
    }

    return rente;
  }
  
  
  private double beregnAfdragsbeløb(Finansieringsaftale aftale)
  {
    double afdragsbeløb = ((aftale.getBeløb() + aftale.getEkstraomkostninger() - aftale.getUdbetaling()) * ((rente/100)/12))/(1- Math.pow(1 + ((rente/100)/12), -aftale.getAfviklingsperiode() ));
    return afdragsbeløb;
  }
  
  
  /*
   * Jeg er overhovedet ikke sikker på at denne er korrekt!!!
   */
  private double beregnÅOP(Finansieringsaftale aftale)
  {
    double åop = (((aftale.getAfdragsbeløb()*aftale.getAfviklingsperiode())-aftale.getBeløb())/aftale.getBeløb())/(aftale.getAfviklingsperiode()*12);
//    double åop = (100 * (((aftale.getAfdragsbeløb()*aftale.getAfviklingsperiode()) - aftale.getBeløb()) / aftale.getBeløb()));
    return åop;
  }
  
  
}
