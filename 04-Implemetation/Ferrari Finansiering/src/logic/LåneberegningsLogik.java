package logic;

import domain.*;
import dataAccess.*;


public class L�neberegningsLogik
{
  public String getKreditV�rdighed(String cprnummer)
  {
    APIConnection ac = new APIConnection();
    String kreditv�rdighed = ac.getKreditV�rdighed( cprnummer );
    return kreditv�rdighed;
  }
  
  public double getRente()
  {
    APIConnection ac = new APIConnection();
    double rente = ac.getRente();
    return rente;
  }
  
  
}
