package dataAccess;

public class KundeAccess
{
  private static final String SELECT = "SELECT navn, adresse, telefonnummer, postnummer, email, kommentar FROM kunde WHERE cprid = ?";
  private static final String SELECT_MANY = "SELECT navn, adresse, telefonnummer, postnummer, email, kommentar FROM kunde WHERE cprid = ? OR navn = ? OR adresse = ? OR telefonnummer = ? OR email = ?";
  private static final String INSERT = "INSERT INTO kunde(navn, adresse, telefonnummer, postnummer, email, kommentar) VALUES (?, ?, ?, ?, ?, ?)"; //Skal cprid, medsendes her.?
  private static final String UPDATE = "UPDATE kunde SET navn = ?, adresse = ?, telefonnummer = ?, postnummer = ?, email = ?, kommentar = ? WHERE cprid = ?";
  private static final String DELETE = "DELETE FROM kunde WHERE cprid = ?";
  
  
  public KundeAccess()
  {
    
  }
  
  
  
  
}
