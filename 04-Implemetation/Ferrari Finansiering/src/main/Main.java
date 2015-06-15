package main;

import java.sql.SQLException;

import logic.DatabaseLogik;
import logic.DatabaseLogikImpl;
import presentation.MainWindow;
import exceptions.KundeAllreadyExist;

public class Main {

	public static void main(String[] args) throws SQLException,
			KundeAllreadyExist {
		DatabaseLogik databaseBuilder = new DatabaseLogikImpl();
		databaseBuilder.createDatabase();
		new MainWindow().SælgerMainPanel();
	}

}
