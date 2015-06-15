package logic;

import java.sql.SQLException;
import java.util.List;

import dataAccess.DbConnection;
import dataAccess.KundeAccess;
import domain.Kunde;
import exceptions.KundeAllreadyExist;
import exceptions.KundeDoesNotExist;


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
      KundeAccess kundeaccess = new KundeAccess();
      kundeaccess.createKunde( kunde );
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
  
  public Kunde readKunde(String cprnummer) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
    KundeAccess kundeaccess = new KundeAccess();
    Kunde kunde = kundeaccess.readKunde( cprnummer );
    
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
  
  public List<Kunde> listKunder(String searchitem, String search) throws SQLException
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
      KundeAccess kundeaccess = new KundeAccess();
//      if(searchitem == "cprnummer")
//      {
//        List<Kunde> list = kundeaccess.listKunder( searchitem, search );
//      }
      List<Kunde> list = kundeaccess.listKunder( searchitem, search );
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
  public void updateKunde(Kunde kunde) throws SQLException, KundeDoesNotExist
  {
    DbConnection dbcon = null;
    try
    {
      dbcon = new DbConnection();
    KundeAccess kundeaccess = new KundeAccess();
    kundeaccess.updateKunde( kunde );
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
    public void deleteKunde(int cprid) throws SQLException, KundeDoesNotExist
    {
      DbConnection dbcon = null;
      try
      {
        dbcon = new DbConnection();
      KundeAccess kundeaccess = new KundeAccess();
      kundeaccess.deleteCprnummer( cprid );
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
