package domain;

public class Kunde
{
  private int cprid;
  private String cprnummer;
  private String navn;
  private String adresse;
  private String telefonnummer;
  private String postnummer;
  private String email;
  private String kommentar;
  private String kreditværdighed;
  
  
  public int getCprid()
  {
    return cprid;
  }
  
  public void setCprid( int cprid )
  {
    this.cprid = cprid;
  }
  
  
  public String getCprnummer()
  {
    return cprnummer;
  }

  public void setCprnummer( String cprnummer )
  {
    this.cprnummer = cprnummer;
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

  
  public String getKreditværdighed()
  {
    return kreditværdighed;
  }

  public void setKreditværdighed( String kreditværdighed )
  {
    this.kreditværdighed = kreditværdighed;
  }

  public String toString()
  {
    return "Kunde [cprid=" + cprid + ", cprnummer=" + cprnummer + ", navn=" + navn + ", adresse=" + adresse + ", telefonnummer=" + telefonnummer + ", postnummer=" + postnummer + ", email=" + email + ", kommentar=" + kommentar + "]";
  }
  
  
}
