package domain;

public class S�lger
{
  private int s�lgerid;
  private String s�lgernavn;
  
  public int getS�lgerid()
  {
    return s�lgerid;
  }
  
  public void setS�lgerid( int s�lgerid )
  {
    this.s�lgerid = s�lgerid;
  }
  
  public String getS�lgernavn()
  {
    return s�lgernavn;
  }
  
  public void setS�lgernavn( String s�lgernavn )
  {
    this.s�lgernavn = s�lgernavn;
  }
  
  @Override
  public String toString()
  {
    return "S�lger [s�lgerid=" + s�lgerid + ", s�lgernavn=" + s�lgernavn + "]";
  }
  
}
