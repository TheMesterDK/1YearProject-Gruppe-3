package dataAccess;

public class FinansieringsaftaleAccess
{
  private static final String SELECT = "SELECT bel�b, rente, afviklingsperiode, oprettelsesdato FROM finansieringsaftale WHERE aftaleid = ?";
//  private static final String SELECT_MANY = "SELECT  FROM finansieringsaftale WHERE ";
  private static final String INSERT = "INSERT INTO finansieringsaftale(bel�b, rente, afviklingsperiode, oprettelsesdato) VALUES (?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE finansieringsaftale SET bel�b = ?, rente = ?, afviklingsperiode = ?, oprettelsesdato = ? WHERE aftaleid = ?";
  private static final String DELETE = "DELETE FROM finansieringsaftale WHERE aftaleid = ?";
  
  
  public FinansieringsaftaleAccess()
  {
    
  }
  
  
  
}
