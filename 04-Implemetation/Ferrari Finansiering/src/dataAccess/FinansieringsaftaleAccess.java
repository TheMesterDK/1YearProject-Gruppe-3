package dataAccess;

import java.sql.*;
import java.util.*;

import domain.Finansieringsaftale;


public class FinansieringsaftaleAccess
{
  private static final String SELECT = "SELECT beløb, rente, afviklingsperiode, oprettelsesdato FROM finansieringsaftale WHERE aftaleid = ?";
//  private static final String SELECT_MANY = "SELECT  FROM finansieringsaftale WHERE ";
  private static final String INSERT = "INSERT INTO finansieringsaftale(beløb, rente, afviklingsperiode, oprettelsesdato) VALUES (?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE finansieringsaftale SET beløb = ?, rente = ?, afviklingsperiode = ?, oprettelsesdato = ? WHERE aftaleid = ?";
  private static final String DELETE = "DELETE FROM finansieringsaftale WHERE aftaleid = ?";
  
  
  public FinansieringsaftaleAccess()
  {
    
  }
  
  
  /*
   * Create
   */
  
  
  
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
