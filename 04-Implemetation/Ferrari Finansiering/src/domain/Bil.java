package domain;

public class Bil
{
  private String chassisnummer;
  private String registreringsnummer;
  private double pris;
  private String model;
  private String �rgang;
  private String bem�rkninger;
  
  public String getChassisnummer()
  {
    return chassisnummer;
  }
  
  public void setChassisnummer( String chassisnummer )
  {
    this.chassisnummer = chassisnummer;
  }
  
  public String getRegistreringsnummer()
  {
    return registreringsnummer;
  }
  
  public void setRegistreringsnummer( String registreringsnummer )
  {
    this.registreringsnummer = registreringsnummer;
  }
  
  public double getPris()
  {
    return pris;
  }
  
  public void setPris( double pris )
  {
    this.pris = pris;
  }
  
  public String getModel()
  {
    return model;
  }
  
  public void setModel( String model )
  {
    this.model = model;
  }
  
  public String get�rgang()
  {
    return �rgang;
  }
  
  public void set�rgang( String �rgang )
  {
    this.�rgang = �rgang;
  }
  
  public String getBem�rkninger()
  {
    return bem�rkninger;
  }
  
  public void setBem�rkninger( String bem�rkninger )
  {
    this.bem�rkninger = bem�rkninger;
  }
  
  @Override
  public String toString()
  {
    return "Bil [" + "chassisnummer=" + chassisnummer + ", registreringsnummer=" + registreringsnummer + ", pris=" + pris + ", model=" + model + ", �rgang=" + �rgang + ", bem�rkninger=" + bem�rkninger + "]";
  }
  
}
