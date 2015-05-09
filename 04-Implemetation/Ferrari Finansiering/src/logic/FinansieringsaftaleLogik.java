package logic;

import java.sql.SQLException;

import dataAccess.FinansieringsaftaleAccess;
import dataAccess.DbConnection;
import domain.Finansieringsaftale;

public class FinansieringsaftaleLogik
{
  
  /*
   * Create
   */
  public void createFinansieringsaftale(Finansieringsaftale aftale) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      FinansieringsaftaleAccess aftaleaccess = new FinansieringsaftaleAccess();
      aftaleaccess.createFinansieringsaftale( aftale );
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
  public Finansieringsaftale readFinansieringsaftale(int aftaleid) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      FinansieringsaftaleAccess aftaleaccess = new FinansieringsaftaleAccess();
      Finansieringsaftale aftale = aftaleaccess.readFinansieringsaftale( aftaleid );
    return aftale;
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
  public void updateFinansieringsaftale(Finansieringsaftale aftale) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      FinansieringsaftaleAccess aftaleaccess = new FinansieringsaftaleAccess();
      aftaleaccess.updateFinansieringsaftale( aftale );
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
    public void deleteFinansieringsaftale(int aftaleid) throws SQLException
    {
      DbConnection dbcon = null;
      try
      {
        dbcon = new DbConnection();
        FinansieringsaftaleAccess aftaleaccess = new FinansieringsaftaleAccess();
        aftaleaccess.deleteFinansieringsaftale( aftaleid );
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
