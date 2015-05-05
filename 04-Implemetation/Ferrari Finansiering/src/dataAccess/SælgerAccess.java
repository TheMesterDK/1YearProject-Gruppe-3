package dataAccess;

import java.sql.*;
import java.util.*;


public class SælgerAccess
{
  private static final String SELECT = "SELECT navn FROM sælger WHERE sælgerid = ?";
//  private static final String SELECT_MANY = "SELECT  FROM  WHERE ";
  private static final String INSERT = "INSERT INTO sælger(sælgernavn) VALUES (?)";
  private static final String UPDATE = "UPDATE sælger SET sælgernavn WHERE sælgerid = ?";
  private static final String DELETE = "DELETE FROM sælger WHERE sælgerid = ?";
  
  
  public SælgerAccess()
  {
    
  }
  
  
  
}
