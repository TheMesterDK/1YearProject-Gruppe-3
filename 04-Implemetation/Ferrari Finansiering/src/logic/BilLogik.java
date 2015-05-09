package logic;

import java.sql.Connection;
import java.sql.SQLException;

import dataAccess.DbConnection;
import dataAccess.BilAccess;
import domain.Bil;


public class BilLogik
{
  
  /*
   * Create
   */
  public void createBil(Bil bil) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      BilAccess bilaccess = new BilAccess();
      bilaccess.createBil( bil );
    }
    catch ( Exception e )
    {
      if ( dbcon != null )
      {
        dbcon.rollback();
      }
      throw e;
    }
    finally
    {
      if ( dbcon != null )
      {
        dbcon.close();
      }
    }
    
  }
  
  
  /*
   * Read
   */
  public Bil readBil(String chassisnummer) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      BilAccess bilaccess = new BilAccess();
      Bil bil = bilaccess.readBil( chassisnummer );
    return bil;
    }
    catch ( Exception e )
    {
      if ( dbcon != null )
      {
        dbcon.rollback();
      }
      throw e;
    }
    finally
    {
      if ( dbcon != null )
      {
        dbcon.close();
      }
    }
    
    
  }
  
  
  /*
   * Update
   */
  public void updateBil(Connection connection, Bil bil) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      BilAccess bilaccess = new BilAccess();
      bilaccess.updateBil( bil );
    }
    catch ( Exception e )
    {
      if ( dbcon != null )
      {
        dbcon.rollback();
      }
      throw e;
    }
    finally
    {
      if ( dbcon != null )
      {
        dbcon.close();
      }
    }
    
    
  }
  
  
    /*
     * Delete
     */  
    public void deleteBil(String chassisnummer) throws SQLException
    {
      DbConnection dbcon = null;
      try
      {
        dbcon = new DbConnection();
        BilAccess bilaccess = new BilAccess();
        bilaccess.deleteBil( chassisnummer );
//      dbcon.commit();
      }
      catch ( Exception e )
      {
        if ( dbcon != null )
        {
          dbcon.rollback();
        }
        throw e;
      }
      finally
      {
        if ( dbcon != null )
        {
          dbcon.close();
        }
      }
    }
  
}
