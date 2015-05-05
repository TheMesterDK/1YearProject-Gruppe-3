package dataAccess;

public class CprnummerAccess
{
  private static final String SELECT = "SELECT cprnummer FROM cprnummer WHERE cprid = ?";
  private static final String SELECT_MANY = "SELECT  FROM  WHERE ";
  private static final String INSERT = "INSERT INTO cprnummer(cprnummer) VALUES(?)";
  private static final String UPDATE = "UPDATE cprnummer SET cprnummer = ? WHERE cprid = ?";
  private static final String DELETE = "DELETE FROM cprnummer WHERE cprid = ?";
  
  
  public CprnummerAccess()
  {
    
  }
  
  
  
}
