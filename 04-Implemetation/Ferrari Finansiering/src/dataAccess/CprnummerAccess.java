package dataAccess;

import java.sql.*;
import java.util.*;


public class CprnummerAccess
{
  private static final String SELECT = "SELECT cprnummer FROM cprnummer WHERE cprid = ?";
//  private static final String SELECT_MANY = "SELECT  FROM  WHERE ";
  private static final String INSERT = "INSERT INTO cprnummer(cprnummer) VALUES(?)";
  private static final String UPDATE = "UPDATE cprnummer SET cprnummer = ? WHERE cprid = ?";
  private static final String DELETE = "DELETE FROM cprnummer WHERE cprid = ?";
  
  
  public CprnummerAccess()
  {
    
  }
  
  
  /*
   * Create
   */
//  void createCprnummer(String cprnummer) throws SQLException
//  {
//    Connection connection = null;
//    try
//    {
//      connection = new DbConnection().getConnection();
//      createCprnummer(connection, cprnummer);
//    }
//    finally
//    {
//      if(connection != null)
//      {
//        connection.close();
//      }
//    }
//  }
//  
//  void createCprnummer(Connection connection, String cprnummer) throws SQLException
//  {
//    PreparedStatement statement = null;
//    ResultSet resultset = null;
//    try 
//    {
//      statement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
//      statement.setString(1, cprnummer);
//      statement.execute();
//      resultset = statement.getGeneratedKeys();
//      
//    } 
//    finally 
//    {
//      if (statement != null) 
//      {
//        statement.close();
//      }
//    }
//  }
  
  
  /*
   * Read
   */
  
  
  
  /*
   * Update
   */
  
  
  
  /*
   * Delete
   */
  
  
  
}
