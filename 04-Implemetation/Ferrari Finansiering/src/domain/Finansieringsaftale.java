package domain;

public class Finansieringsaftale
{
  private int aftaleid;
  private int cprid;
  private int sælgerid;
  private String chassisnummer;
  private double beløb;
  private double udbetaling;
  private double rente;
  private int afviklingsperiode;
  private String oprettelsesdato;
  
  
  public int getAftaleid()
  {
    return aftaleid;
  }
  
  public void setAftaleid( int aftaleid )
  {
    this.aftaleid = aftaleid;
  }
  
  
  public int getCprid()
  {
    return cprid;
  }
  
  public void setCprid( int cprid )
  {
    this.cprid = cprid;
  }
  
  
  public int getSælgerid()
  {
    return sælgerid;
  }
  
  public void setSælgerid( int sælgerid )
  {
    this.sælgerid = sælgerid;
  }
  
  
  public String getChassisnummer()
  {
    return chassisnummer;
  }
  
  public void setChassisnummer( String chassisnummer )
  {
    this.chassisnummer = chassisnummer;
  }
  
  
  public double getBeløb()
  {
    return beløb;
  }
  
  public void setBeløb( double beløb )
  {
    this.beløb = beløb;
  }
  
  
  public double getUdbetaling()
  {
    return udbetaling;
  }

  public void setUdbetaling( double udbetaling )
  {
    this.udbetaling = udbetaling;
  }

  
  public double getRente()
  {
    return rente;
  }
  
  public void setRente( double rente )
  {
    this.rente = rente;
  }
  
  
  public int getAfviklingsperiode()
  {
    return afviklingsperiode;
  }
  
  public void setAfviklingsperiode( int afviklingsperiode )
  {
    this.afviklingsperiode = afviklingsperiode;
  }
  
  
  public String getOprettelsesdato()
  {
    return oprettelsesdato;
  }
  
  public void setOprettelsesdato( String oprettelsesdato )
  {
    this.oprettelsesdato = oprettelsesdato;
  }

  
  @Override
  public String toString()
  {
    return "Finansieringsaftale [aftaleid=" + aftaleid + ", cprid=" + cprid + ", sælgerid=" + sælgerid + ", chassisnummer=" + chassisnummer + ", beløb=" + beløb + ", udbetaling=" + udbetaling + ", rente=" + rente + ", afviklingsperiode=" + afviklingsperiode + ", oprettelsesdato=" + oprettelsesdato + "]";
  }
  
  
}
