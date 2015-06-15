package logging;

import java.util.Collection;

import logic.ObserverSingleton;

public class Logger
{
  public void log( String title, String message, Errors error )
  {
    Objects logEntry = new Objects();
    logEntry.setTitle( title );
    logEntry.setMessage( message );
    logEntry.setErrorType( error );
    Container.instance().log( logEntry );
    
    // Add call to observer
    ObserverSingleton.instance().notifyObservers();
  }
  
  public Collection<Object> getLog()
  {
    
    return Container.instance().getLog();
  }
  
  public void clearLog()
  {
    
    Container.instance().clearLog();
  }
}
