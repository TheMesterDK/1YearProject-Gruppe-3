package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Finansieringsaftale;

public class FinansieringsaftaleAccess {
	private static final String SELECT = "SELECT beløb, udbetaling, rente, afviklingsperiode, oprettelsesdato, førsteafbetalingdato, afdragsbeløb, sælgerid, chassisnummer, cprid FROM finansieringsaftale WHERE aftaleid = ?";
	private static final String INSERT = "INSERT INTO finansieringsaftale(beløb, udbetaling, rente, afviklingsperiode, oprettelsesdato, førsteafbetalingdato, afdragsbeløb, sælgerid, chassisnummer, cprid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE finansieringsaftale SET beløb = ?, udbetaling = ?, rente = ?, afviklingsperiode = ?, oprettelsesdato = ?, førsteafbetalingdato = ?, afdragsbeløb = ?, sælgerid = ?, chassisnummer = ?, cprid = ? WHERE aftaleid = ?";
	private static final String DELETE = "DELETE FROM finansieringsaftale WHERE aftaleid = ?";

	public FinansieringsaftaleAccess() {

	}

	/*
	 * Create
	 */
	public void createFinansieringsaftale(Finansieringsaftale aftale)
			throws SQLException {
		Connection connection = null;
		try {
			connection = new DbConnection().getConnection();
			createFinansieringsaftale(connection, aftale);
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public void createFinansieringsaftale(Connection connection,
			Finansieringsaftale aftale) throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(INSERT);
			statement.setDouble(1, aftale.getBeløb());
			statement.setDouble(2, aftale.getUdbetaling());
			statement.setDouble(3, aftale.getRente());
			statement.setInt(4, aftale.getAfviklingsperiode());
			statement.setString(5, aftale.getOprettelsesdato());
			statement.setString(6, aftale.getFørsteafbetalingdato());
			statement.setDouble(8, aftale.getAfdragsbeløb());
			statement.setInt(10, aftale.getSælgerid());
			statement.setString(11, aftale.getChassisnummer());
			statement.setInt(12, aftale.getCprid());
			statement.execute();
			connection.commit();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}

	}

	/*
	 * Read
	 */
	public Finansieringsaftale readFinansieringsaftale(int aftaleid)
			throws SQLException {
		Connection connection = null;
		try {
			connection = new DbConnection().getConnection();
			return readFinansieringsaftale(connection, aftaleid);
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public Finansieringsaftale readFinansieringsaftale(Connection connection,
			int aftaleid) throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultset = null;
		Finansieringsaftale aftale = null;
		try {
			statement = connection.prepareStatement(SELECT);
			statement.setInt(1, aftaleid);
			resultset = statement.executeQuery();
			aftale = new Finansieringsaftale();
			aftale.setAftaleid(aftaleid);
			while (resultset.next()) {
				aftale.setBeløb(resultset.getDouble("beløb"));
				aftale.setUdbetaling(resultset.getDouble("udbetaling"));
				aftale.setRente(resultset.getDouble("rente"));
				aftale.setAfviklingsperiode(resultset
						.getInt("afviklingsperiode"));
				aftale.setOprettelsesdato(resultset
						.getString("oprettelsesdato"));
				aftale.setFørsteafbetalingdato(resultset
						.getString("førsteafbetalingdato"));
				aftale.setAfdragsbeløb(resultset.getDouble("afdragsbeløb"));
				aftale.setSælgerid(resultset.getInt("sælgerid"));
				aftale.setChassisnummer(resultset.getString("chassisnummer"));
				aftale.setCprid(resultset.getInt("cprid"));
			}
			return aftale;
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
		}

	}

	public List<Finansieringsaftale> listFinansieringsaftaler(
			String searchitem, String search) throws SQLException {
		Connection connection = null;
		try {
			connection = new DbConnection().getConnection();
			return listFinansieringsaftaler(connection, searchitem, search);
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public List<Finansieringsaftale> listFinansieringsaftaler(
			Connection connection, String searchitem, String search)
			throws SQLException {
		PreparedStatement statement = null;
		ResultSet resultset = null;
		List<Finansieringsaftale> list = new ArrayList<>();
		try {
			String SEARCH = "SELECT * FROM finansieringsaftale where "
					+ searchitem + " LIKE ?";
			statement = connection.prepareStatement(SEARCH);
			statement.setString(1, "%" + search + "%");
			resultset = statement.executeQuery();
			while (resultset.next()) {
				Finansieringsaftale aftale = new Finansieringsaftale();
				aftale.setAftaleid(resultset.getInt("aftaleid"));
				aftale.setBeløb(resultset.getDouble("beløb"));
				aftale.setUdbetaling(resultset.getDouble("udbetaling"));
				aftale.setRente(resultset.getDouble("rente"));
				aftale.setAfviklingsperiode(resultset
						.getInt("afviklingsperiode"));
				aftale.setOprettelsesdato(resultset
						.getString("oprettelsesdato"));
				aftale.setFørsteafbetalingdato(resultset
						.getString("førsteafbetalingdato"));
				aftale.setAfdragsbeløb(resultset.getDouble("afdragsbeløb"));
				aftale.setSælgerid(resultset.getInt("sælgerid"));
				aftale.setChassisnummer(resultset.getString("chassisnummer"));
				aftale.setCprid(resultset.getInt("cprid"));
				list.add(aftale);
			}
			return list;
		} finally {
			if (resultset != null) {
				resultset.close();
			}
			if (statement != null) {
				statement.close();
			}
		}
	}

	/*
	 * Update
	 */
	public void updateFinansieringsaftale(Finansieringsaftale aftale)
			throws SQLException {
		Connection connection = null;
		try {
			connection = new DbConnection().getConnection();
			updateFinansieringsaftale(connection, aftale);
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public void updateFinansieringsaftale(Connection connection,
			Finansieringsaftale aftale) throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(UPDATE);
			statement.setDouble(1, aftale.getBeløb());
			statement.setDouble(2, aftale.getUdbetaling());
			statement.setDouble(3, aftale.getRente());
			statement.setInt(4, aftale.getAfviklingsperiode());
			statement.setString(5, aftale.getOprettelsesdato());
			statement.setString(6, aftale.getFørsteafbetalingdato());
			statement.setDouble(8, aftale.getAfdragsbeløb());
			statement.setInt(10, aftale.getSælgerid());
			statement.setString(11, aftale.getChassisnummer());
			statement.setInt(12, aftale.getCprid());
			statement.execute();
			connection.commit();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}

	}

	/*
	 * Delete
	 */

	public void deleteFinansieringsaftale(int aftaleid) throws SQLException {
		Connection connection = null;
		try {
			connection = new DbConnection().getConnection();
			deleteFinansieringsaftale(connection, aftaleid);
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public void deleteFinansieringsaftale(Connection connection, int aftaleid)
			throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(DELETE);
			statement.setInt(1, aftaleid);
			statement.execute();
			connection.commit();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

}
