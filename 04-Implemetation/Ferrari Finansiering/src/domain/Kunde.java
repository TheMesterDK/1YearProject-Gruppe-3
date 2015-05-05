package domain;

public class Kunde
{
  private int cprid;
  private String navn;
  private String adresse;
  private String telefonnummer;
  private String postnummer;
  private String email;
  private String kommentar;
  
  
  public int getCprid()
  {
    return cprid;
  }
  
  public void setCprid( int cprid )
  {
    this.cprid = cprid;
  }
  
  
  public String getNavn()
  {
    return navn;
  }
  
  public void setNavn( String navn )
  {
    this.navn = navn;
  }
  
  
  public String getAdresse()
  {
    return adresse;
  }
  
  public void setAdresse( String adresse )
  {
    this.adresse = adresse;
  }
  
  
  public String getTelefonnummer()
  {
    return telefonnummer;
  }
  
  public void setTelefonnummer( String telefonnummer )
  {
    this.telefonnummer = telefonnummer;
  }
  
  
  public String getPostnummer()
  {
    return postnummer;
  }
  
  public void setPostnummer( String postnummer )
  {
    this.postnummer = postnummer;
  }
  
  
  public String getEmail()
  {
    return email;
  }
  
  public void setEmail( String email )
  {
    this.email = email;
  }
  
  
  public String getKommentar()
  {
    return kommentar;
  }
  
  public void setKommentar( String kommentar )
  {
    this.kommentar = kommentar;
  }

  
  @Override
  public String toString()
  {
    return "Kunde [cprid=" + cprid + ", navn=" + navn + ", adresse=" + adresse + ", telefonnummer=" + telefonnummer + ", postnummer=" + postnummer + ", email=" + email + ", kommentar=" + kommentar + "]";
  }
  
  
}
