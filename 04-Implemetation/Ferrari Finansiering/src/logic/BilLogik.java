package logic;

import java.sql.SQLException;
import java.util.List;

import dataAccess.BilAccess;
import dataAccess.DbConnection;
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
  
  public List<Bil> listBiler(String searchitem, String search) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      BilAccess bilaccess = new BilAccess();
      List<Bil> list = bilaccess.listBiler( searchitem, search );
      return list;
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
  public void updateBil(Bil bil) throws SQLException
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
