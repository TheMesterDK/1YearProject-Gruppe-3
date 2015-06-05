package main;

import java.sql.SQLException;

import presentation.MainWindow;
import exceptions.KundeAllreadyExist;



public class Main
{
  
  public static void main( String[] args ) throws SQLException, KundeAllreadyExist
  {
    new MainWindow().SælgerMainPanel();
        
  }
  
}



