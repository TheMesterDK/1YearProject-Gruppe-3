package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class DatabaseScript
{
  //Here will be added the creation of the remaining tables.
  private static final String FOREIGN_KEYS_ON = "PRAGMA foreign_keys = ON";
  private static final String CREATE_CPRNUMMER_TABLE = "CREATE TABLE IF NOT EXISTS Cprnummer(Cprid int identity primary key, Cprnummer char(10) unique not null)";
  private static final String CREATE_KUNDE_TABLE = "CREATE TABLE IF NOT EXISTS Kunde(Cprid int primary key, Navn varchar(100) not null, Adresse varchar(100) not null, Telefonnummer varchar(65), Postnummer char(4), Email varchar(100), Kommentar varchar(250), Foreign key (cprid) References cprnummer (cprid) on update cascade on delete cascade)";
  private static final String CREATE_SÆLGER_TABLE = "CREATE TABLE IF NOT EXISTS Sælger(Sælgerid int identity primary key, sælgernavn varchar(100))";
  private static final String CREATE_BIL_TABLE = "CREATE TABLE IF NOT EXISTS Bil(Chassisnummer varchar(100) primary key, Registreringsnummer varchar(10), Pris double not null, Model varchar(100), Årgang char(4), Bemærkninger varchar(250))";
  private static final String CREATE_FINANSIERINGSAFTALE_TABLE = "CREATE TABLE IF NOT EXISTS Finansieringsaftale(Aftaleid int identity primary key, Beløb double not null, Udbetaling double not null, Rente double not null, Afviklingsperiode int not null, Oprettelsesdato char(10) not null, Førsteafbetalingdato char(10) not null, Afdragsbeløb double not null, Sælgerid int, Foreign key (sælgerid) References sælger (sælgerid), Chassisnummer varchar(100), Foreign key (chassisnummer) References bil (chassisnummer) on update cascade on delete cascade, Cprid int, Foreign key (cprid) References cprnummer (cprid) on update cascade)";
  
  
  public void createDb(Connection connection) throws SQLException 
  {
    createTable(connection, FOREIGN_KEYS_ON);
    createTable(connection, CREATE_CPRNUMMER_TABLE);
    createTable(connection, CREATE_KUNDE_TABLE);
    createTable(connection, CREATE_SÆLGER_TABLE);
    createTable(connection, CREATE_BIL_TABLE);
    createTable(connection, CREATE_FINANSIERINGSAFTALE_TABLE);
//    DefaultData(connection);
  }
  
  
  private void createTable(Connection connection, String sql) throws SQLException 
  {
    
    PreparedStatement statement = null;
    
    try 
    {
      statement = connection.prepareStatement(sql);
      statement.execute();
      connection.commit();
    } 
    finally 
    {
      if (statement != null)
      {
        statement.close();
      }
    }
  }
  
//  private void DefaultData(Connection connection)
//  {
//    
//    CarDAO carDAO = new CarDAOImpl();
//    SalesmanDAO salesmanDAO = new SalesmanDAOImpl();
//    
//    List <Car> defaultCars = new ArrayList<Car>();
//    
//    Salesman salesman = new Salesman();
//    salesman.setLoanValueLimit(1_000_000);
//    
//    defaultCars.add(addDefaultCar("458", 1_900_000));
//    defaultCars.add(addDefaultCar("FF", 2_000_000));
//    defaultCars.add(addDefaultCar("LaFerrari", 9_500_000));
//    
//    try {
//    if(carDAO.readAllCars(connection).isEmpty()){
//      for (Car car : defaultCars) {
//        carDAO.createCar(connection, car);
//      }
//      
//      }
//    if(salesmanDAO.readAllSalesman(connection).isEmpty()){
//      salesmanDAO.createSalesman(connection, salesman);
//    }
//  } catch (SQLException e) {
//    e.printStackTrace();
//  }
//  }
//  
//  private Car addDefaultCar(String model, double price) {
//    
//      Car car = new Car();
//      car.setModel(model);
//      car.setPrice(price);
//  
//      return car;
//    }
}
