package dataAccess;

public class S�lgerAccess
{
  private static final String SELECT = "SELECT navn FROM s�lger WHERE s�lgerid = ?";
//  private static final String SELECT_MANY = "SELECT  FROM  WHERE ";
  private static final String INSERT = "INSERT INTO s�lger(s�lgernavn) VALUES (?)";
  private static final String UPDATE = "UPDATE s�lger SET s�lgernavn WHERE s�lgerid = ?";
  private static final String DELETE = "DELETE FROM s�lger WHERE s�lgerid = ?";
  
  
  public S�lgerAccess()
  {
    
  }
  
  
  
}
