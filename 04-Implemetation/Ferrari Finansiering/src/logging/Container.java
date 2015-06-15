package logging;

import java.util.ArrayList;
import java.util.Collection;

public class Container
{
  private Collection<Object> log = new ArrayList<Object>();
  
  private static class Holder 
  {
    // private class and no lazy initialization makes a singleton thread safe
    static final Container instance = new Container();
  };
  
  public static Container instance() 
  {
    
    return Holder.instance;
  }
  
  private Container() 
  {
  }
  
  public void log(Object logEntry) 
  {

    log.add(logEntry);
  }

  public Collection<Object> getLog() {
    
    return log;
  }

  public void clearLog() {

    log.clear();
  }
}
