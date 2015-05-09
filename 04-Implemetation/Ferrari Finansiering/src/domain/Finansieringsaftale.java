package domain;

import java.sql.Timestamp;

public class Finansieringsaftale
{
  private int aftaleid;
  private int cprid;
  private int s�lgerid;
  private String chassisnummer;
  private double bel�b;
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
  
  
  public int getS�lgerid()
  {
    return s�lgerid;
  }
  
  public void setS�lgerid( int s�lgerid )
  {
    this.s�lgerid = s�lgerid;
  }
  
  
  public String getChassisnummer()
  {
    return chassisnummer;
  }
  
  public void setChassisnummer( String chassisnummer )
  {
    this.chassisnummer = chassisnummer;
  }
  
  
  public double getBel�b()
  {
    return bel�b;
  }
  
  public void setBel�b( double bel�b )
  {
    this.bel�b = bel�b;
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
    return "Finansieringsaftale [aftaleid=" + aftaleid + ", cprid=" + cprid + ", s�lgerid=" + s�lgerid + ", chassisnummer=" + chassisnummer + ", bel�b=" + bel�b + ", udbetaling=" + udbetaling + ", rente=" + rente + ", afviklingsperiode=" + afviklingsperiode + ", oprettelsesdato=" + oprettelsesdato + "]";
  }
  
  
}
