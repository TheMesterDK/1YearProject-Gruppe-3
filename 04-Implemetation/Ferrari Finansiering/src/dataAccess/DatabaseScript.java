package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import domain.Bil;

public class DatabaseScript {
	// Here will be added the creation of the remaining tables.
	private static final String FOREIGN_KEYS_ON = "PRAGMA foreign_keys = ON";
	private static final String CREATE_CPRNUMMER_TABLE = "CREATE TABLE IF NOT EXISTS Cprnummer(Cprid int identity primary key, Cprnummer char(10) unique not null)";
	private static final String CREATE_KUNDE_TABLE = "CREATE TABLE IF NOT EXISTS Kunde(Cprid int primary key, Navn varchar(100) not null, Adresse varchar(100) not null, Telefonnummer varchar(65), Postnummer char(4), Email varchar(100), Kommentar varchar(250), Foreign key (cprid) References cprnummer (cprid) on update cascade on delete cascade)";
	private static final String CREATE_SÆLGER_TABLE = "CREATE TABLE IF NOT EXISTS Sælger(Sælgerid int identity primary key, sælgernavn varchar(100))";
	private static final String CREATE_BIL_TABLE = "CREATE TABLE IF NOT EXISTS Bil(Chassisnummer varchar(100) primary key, Registreringsnummer varchar(10), Pris double not null, Model varchar(100), Årgang char(4), Bemærkninger varchar(250))";
	private static final String CREATE_FINANSIERINGSAFTALE_TABLE = "CREATE TABLE IF NOT EXISTS Finansieringsaftale(Aftaleid int identity primary key, Beløb double not null, Udbetaling double not null, Rente double not null, Afviklingsperiode int not null, Oprettelsesdato char(10) not null, Førsteafbetalingdato char(10) not null, Afdragsbeløb double not null, Sælgerid int, Foreign key (sælgerid) References sælger (sælgerid), Chassisnummer varchar(100), Foreign key (chassisnummer) References bil (chassisnummer) on update cascade on delete cascade, Cprid int, Foreign key (cprid) References cprnummer (cprid) on update cascade)";

	public void createDb(Connection connection) throws SQLException {
		createTable(connection, FOREIGN_KEYS_ON);
		createTable(connection, CREATE_CPRNUMMER_TABLE);
		createTable(connection, CREATE_KUNDE_TABLE);
		createTable(connection, CREATE_SÆLGER_TABLE);
		createTable(connection, CREATE_BIL_TABLE);
		createTable(connection, CREATE_FINANSIERINGSAFTALE_TABLE);
		// DefaultData( connection );
	}

	private void createTable(Connection connection, String sql)
			throws SQLException {

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

	// private void DefaultData( Connection connection )
	// {
	//
	// BilAccess ba = new BilAccess();
	//
	// List<Bil> defaultCars = new ArrayList<Bil>();
	//
	// defaultCars.add( addDefaultCar( "a1b23n4567mk98", "aa12345", 1000000,
	// "Ascari", "2005", "Prototype" ) );
	// defaultCars.add( addDefaultCar( "b1b23n4567mk98", "bb12345", 2000000,
	// "Berlinetta Boxer", "1984", "" ) );
	// defaultCars.add( addDefaultCar( "c1b23n4567mk98", "cc12345", 300000,
	// "California", "2009", "Import" ) );
	//
	// try
	// {
	// if ( ba.listBiler( connection, "Chassisnummer", "" ).isEmpty() )
	// {
	// for ( Bil bil : defaultCars )
	// {
	// ba.createBil( connection, bil );
	// }
	//
	// }
	// }
	// catch ( SQLException e )
	// {
	// e.printStackTrace();
	// }
	// }
	//
	// private Bil addDefaultCar( String chassisnummer, String
	// registreringsnummer, double pris, String model, String årgang, String
	// bemærkninger )
	// {
	//
	// Bil bil = new Bil();
	// bil.setChassisnummer( chassisnummer );
	// bil.setRegistreringsnummer( registreringsnummer );
	// bil.setPris( pris );
	// bil.setModel( model );
	// bil.setÅrgang( årgang );
	// bil.setBemærkninger( bemærkninger );
	//
	// return bil;
	// }

}
