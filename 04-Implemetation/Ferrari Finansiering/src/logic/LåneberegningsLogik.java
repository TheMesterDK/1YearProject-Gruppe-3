package logic;

import domain.*;
import dataAccess.*;


public class LåneberegningsLogik
{
  public String getKreditVærdighed(String cprnummer)
  {
    APIConnection ac = new APIConnection();
    String kreditværdighed = ac.getKreditVærdighed( cprnummer );
    return kreditværdighed;
  }
  
  public double getRente()
  {
    APIConnection ac = new APIConnection();
    double rente = ac.getRente();
    return rente;
  }
  
  
}
