package logic;

import java.util.ArrayList;
import java.util.List;

public class ObserverSingleton
{
  private static ObserverSingleton instance = null;
  private List<FFSObserver> observers = new ArrayList<>();
  
  public static ObserverSingleton instance() 
  {
    if (instance == null)
      instance = new ObserverSingleton();
    return instance;
  }
  
  private ObserverSingleton() 
  {
    
  }
  
  public void addObserver(FFSObserver observer) 
  {
    if (observer != null && !observers.contains(observer))
      observers.add(observer);
  }

  public void notifyObservers() 
  {
    for (FFSObserver observer : observers)
      observer.update();
  }
}
