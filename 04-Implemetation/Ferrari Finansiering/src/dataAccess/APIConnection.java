package dataAccess;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;


public class APIConnection
{
  
  private String kreditv�rdighed;
  private double rente;
  
  
  private String getRKIKredit(String cprnummer)
  {
    return CreditRator.i().rate( cprnummer ).toString();
  }
  
  private double getBankRente()
  {
    return InterestRate.i().todaysRate();
  }
  
  
  public String getKreditV�rdighed(String cprnummer)
  {
    Thread kvthread = new Thread()
    {
      public void run()
      {
        kreditv�rdighed = getRKIKredit(cprnummer);
      }
    };
    
    return kreditv�rdighed;
  }
  
  
  public double getRente()
  {
    Thread rentethread = new Thread()
    {
      public void run()
      {
        rente = getBankRente();
      }
    };
    
    return rente;
  }
  
}
