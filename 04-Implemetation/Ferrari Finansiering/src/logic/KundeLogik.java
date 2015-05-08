package logic;

import java.sql.Connection;
import java.sql.SQLException;

import dataAccess.DbConnection;
import dataAccess.KundeAccess;
import dataAccess.CprnummerAccess;
import domain.Kunde;
import exceptions.KundeAllreadyExist;


public class KundeLogik
{
  
  /*
   * Create
   */
  public void createKunde(Kunde kunde) throws SQLException, KundeAllreadyExist
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      CprnummerAccess cpraccess = new CprnummerAccess();
      cpraccess.createCprnummer( kunde );
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
  
  
  /*
   * Read
   */
  public Kunde readKunde(int cprid) throws SQLException, KundeAllreadyExist
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
    KundeAccess kundeaccess = new KundeAccess();
    Kunde kunde = kundeaccess.readKunde( cprid );
//    dbcon.commit();
    return kunde;
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
  public void updateKunde(Connection connection, Kunde kunde) throws SQLException, KundeAllreadyExist
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
    KundeAccess kundeaccess = new KundeAccess();
    kundeaccess.updateKunde( kunde );
//    dbcon.commit();
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
    public void deleteKunde(int cprid) throws SQLException, KundeAllreadyExist
    {
      DbConnection dbcon = null;
      try
      {
        dbcon = new DbConnection();
      CprnummerAccess cpraccess = new CprnummerAccess();
      cpraccess.deleteCprnummer( cprid );
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
