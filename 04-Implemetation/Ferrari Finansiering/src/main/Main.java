package main;

import java.sql.SQLException;

import domain.*;
import exceptions.KundeAllreadyExist;
import presentation.MainWindow;
import prototypes.*;
import logic.*;


public class Main
{
  
  public static void main( String[] args ) throws SQLException, KundeAllreadyExist
  {
    new MainWindow().SælgerMainPanel();    
  }
  
}



