package logic;

import java.sql.Connection;
import java.sql.SQLException;


import dataAccess.DbConnection;
import dataAccess.S�lgerAccess;
import domain.S�lger;


public class S�lgerLogik
{
  
  /*
   * Create
   */
  public void createS�lger(S�lger s�lger) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      S�lgerAccess s�lgeraccess = new S�lgerAccess();
      s�lgeraccess.createS�lger( s�lger );
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
  public S�lger readS�lger(int s�lgerid) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      S�lgerAccess s�lgeraccess = new S�lgerAccess();
      S�lger s�lger = s�lgeraccess.readS�lgernavn( s�lgerid );
    return s�lger;
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
  public void updateS�lger(S�lger s�lger) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      S�lgerAccess s�lgeraccess = new S�lgerAccess();
      s�lgeraccess.updateS�lger( s�lger );
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
    public void deleteS�lger(int s�lgerid) throws SQLException
    {
      DbConnection dbcon = null;
      try
      {
        dbcon = new DbConnection();
        S�lgerAccess s�lgeraccess = new S�lgerAccess();
        s�lgeraccess.deleteS�lger( s�lgerid );
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
