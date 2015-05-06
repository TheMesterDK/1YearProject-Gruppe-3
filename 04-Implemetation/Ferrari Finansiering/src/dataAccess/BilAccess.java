package dataAccess;

import java.sql.*;
import java.util.*;

import domain.Bil;


public class BilAccess
{
  private static final String SELECT = "SELECT registreringsnummer, pris, model, �rgang, bem�rkninger FROM bil WHERE chassisnummer = ?";
//  private static final String SELECT_MANY = "SELECT registreringsnummer, pris, model, �rgang, bem�rkninger FROM bil WHERE ";
  private static final String INSERT = "INSERT INTO bil(registreringsnummer, pris, model, �rgang, bem�rkninger) VALUES (?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE bil SET registreringsnummer = ?, pris = ?, model = ?, �rgang = ?, bem�rkninger = ? WHERE chassisnummer = ?";
  private static final String DELETE = "DELETE FROM bil WHERE chassisnummer = ?";
  
  
  public BilAccess()
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
