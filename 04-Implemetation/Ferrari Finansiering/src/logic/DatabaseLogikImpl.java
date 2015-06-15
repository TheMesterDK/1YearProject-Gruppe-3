package logic;

import java.sql.Connection;
import java.sql.SQLException;

import logging.Errors;
import logging.Logger;
import dataAccess.DatabaseScript;
import dataAccess.DbConnection;

public class DatabaseLogikImpl implements DatabaseLogik
{
  
  private Logger logger = new Logger();
  
  @Override
  public void createDatabase()
  {
    try
    {
      DbConnection connect = new DbConnection();
      Connection connection = connect.getConnection();
      DatabaseScript dbSetup = new DatabaseScript();
      dbSetup.createDb( connection );
      connection.close();
      ObserverSingleton.instance().notifyObservers();
    }
    catch ( SQLException e )
    {
      logger.log( "DB error", "Error setting up database.\n" + e.getMessage(), Errors.ERROR );
    }
  }
  
}
