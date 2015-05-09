package logic;

import java.sql.Connection;
import java.sql.SQLException;


import dataAccess.DbConnection;
import dataAccess.SælgerAccess;
import domain.Sælger;


public class SælgerLogik
{
  
  /*
   * Create
   */
  public void createSælger(Sælger sælger) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      SælgerAccess sælgeraccess = new SælgerAccess();
      sælgeraccess.createSælger( sælger );
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
  public Sælger readSælger(int sælgerid) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      SælgerAccess sælgeraccess = new SælgerAccess();
      Sælger sælger = sælgeraccess.readSælgernavn( sælgerid );
    return sælger;
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
  public void updateSælger(Connection connection, Sælger sælger) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      SælgerAccess sælgeraccess = new SælgerAccess();
      sælgeraccess.updateSælgernavn( sælger );
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
    public void deleteSælger(int sælgerid) throws SQLException
    {
      DbConnection dbcon = null;
      try
      {
        dbcon = new DbConnection();
        SælgerAccess sælgeraccess = new SælgerAccess();
        sælgeraccess.deleteSælger( sælgerid );
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
