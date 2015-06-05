package logic;

import dataAccess.APIConnection;
import domain.Finansieringsaftale;


public class L�neberegningsLogik
{
  private double rente;
  
  
  public String getKreditV�rdighed(String cprnummer)
  {
    APIConnection ac = new APIConnection();
    return ac.getKreditV�rdighed( cprnummer );
  }
  
  
  public Finansieringsaftale beregnTilbud(String kreditv�rdighed, Finansieringsaftale aftale)
  {
    aftale.setRente( beregnRente(kreditv�rdighed, aftale) );
    aftale.setAfdragsbel�b( beregnAfdragsbel�b(aftale) );
    aftale.set�op( beregn�OP(aftale) );
    
    return aftale;
  }
  
  
  private double beregnRente(String kreditv�rdighed, Finansieringsaftale aftale)
  {

    APIConnection ac = new APIConnection();
    rente = ac.getRente();
    
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
    
    
    if((aftale.getBel�b()/aftale.getUdbetaling()) > 2)
    {
      rente += 1;
    }

    return rente;
  }
  
  
  private double beregnAfdragsbel�b(Finansieringsaftale aftale)
  {
    double afdragsbel�b = ((aftale.getBel�b() + aftale.getEkstraomkostninger() - aftale.getUdbetaling()) * ((rente/100)/12))/(1- Math.pow(1 + ((rente/100)/12), -aftale.getAfviklingsperiode() ));
    return afdragsbel�b;
  }
  
  
  /*
   * Jeg er overhovedet ikke sikker p� at denne er korrekt!!!
   */
  private double beregn�OP(Finansieringsaftale aftale)
  {
    double �op = (((aftale.getAfdragsbel�b()*aftale.getAfviklingsperiode())-aftale.getBel�b())/aftale.getBel�b())/(aftale.getAfviklingsperiode()*12);
//    double �op = (100 * (((aftale.getAfdragsbel�b()*aftale.getAfviklingsperiode()) - aftale.getBel�b()) / aftale.getBel�b()));
    return �op;
  }
  
  
}
