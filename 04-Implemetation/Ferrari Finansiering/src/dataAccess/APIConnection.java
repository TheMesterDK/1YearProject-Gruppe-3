package dataAccess;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;


public class APIConnection
{
  
  private String kreditværdighed;
  private double rente;
  
  
  private String getRKIKredit(String cprnummer)
  {
    return CreditRator.i().rate( cprnummer ).toString();
  }
  
  private double getBankRente()
  {
    return InterestRate.i().todaysRate();
  }
  
  
  public String getKreditVærdighed(String cprnummer)
  {
    Thread kvthread = new Thread()
    {
      public void run()
      {
        kreditværdighed = getRKIKredit(cprnummer);
      }
    };
    
    return kreditværdighed;
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
