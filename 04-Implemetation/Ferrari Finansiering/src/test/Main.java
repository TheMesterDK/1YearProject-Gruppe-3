package test;

import java.sql.SQLException;

import domain.*;
import exceptions.KundeAllreadyExist;
import prototypes.*;
import logic.*;


public class Main
{
  
  public static void main( String[] args ) throws SQLException, KundeAllreadyExist
  {
    new MainWindow().S�lgerMainPanel();
//    KundeLogik kl = new KundeLogik();
//    Kunde kunde = kl.readKunde( 20 );
//    new EditDialog(kunde);
    
  }
  
}



