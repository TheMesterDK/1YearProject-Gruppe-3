package domain;

public class Bil
{
  private String chassisnummer;
  private String registreringsnummer;
  private double pris;
  private String model;
  private String årgang;
  private String bemærkninger;
  
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
  
  public String getÅrgang()
  {
    return årgang;
  }
  
  public void setÅrgang( String årgang )
  {
    this.årgang = årgang;
  }
  
  public String getBemærkninger()
  {
    return bemærkninger;
  }
  
  public void setBemærkninger( String bemærkninger )
  {
    this.bemærkninger = bemærkninger;
  }
  
  @Override
  public String toString()
  {
    return "Bil [" + "chassisnummer=" + chassisnummer + ", registreringsnummer=" + registreringsnummer + ", pris=" + pris + ", model=" + model + ", årgang=" + årgang + ", bemærkninger=" + bemærkninger + "]";
  }
  
}
