package test;

import java.sql.SQLException;

import exceptions.KundeAllreadyExist;

public class KundeAccessTest {

	public static void main(String[] args) throws SQLException,
			KundeAllreadyExist {
		/*
		 * Test createCprnummer (Og derigennem createKunde). PASSED
		 */
		// Kunde kunde = new Kunde();
		// kunde.setCprnummer( "0406841545" );
		// kunde.setNavn( "Anders" );
		// kunde.setAdresse( "Aagade 35" );
		// kunde.setPostnummer( "8600" );
		// kunde.setTelefonnummer( "12345678" );
		// kunde.setEmail( "Anders@Aagade.dk" );
		// kunde.setKommentar( "God Kunde" );
		//
		// // CprnummerAccess cpraccess = new CprnummerAccess();
		// // cpraccess.createCprnummer(kunde);
		//
		// KundeLogik kl = new KundeLogik();
		// kl.createKunde( kunde );
		//
		//
		// kunde = new Kunde();
		// kunde.setCprnummer( "0408841545" );
		// kunde.setNavn( "Bent" );
		// kunde.setAdresse( "Bredgade 5" );
		// kunde.setPostnummer( "8660" );
		// kunde.setTelefonnummer( "23456789" );
		// kunde.setEmail( "Bent@Bredgade.dk" );
		// kunde.setKommentar( "D�rlig kunde" );
		//
		// kl = new KundeLogik();
		// kl.createKunde( kunde );
		//
		//
		// kunde = new Kunde();
		// kunde.setCprnummer( "0406921545" );
		// kunde.setNavn( "Charlie" );
		// kunde.setAdresse( "Chagade 3" );
		// kunde.setPostnummer( "8600" );
		// kunde.setTelefonnummer( "34567890" );
		// kunde.setEmail( "Charlie@Chagade.dk" );
		// kunde.setKommentar( "Kunde" );
		//
		// kl = new KundeLogik();
		// kl.createKunde( kunde );

		/*
		 * test af readkunde PASSED
		 */
		// // KundeAccess ka = new KundeAccess();
		// KundeLogik kl = new KundeLogik();
		// System.out.println(kl.readKunde( 19 ).toString());

		/*
		 * Test af ListKunder PASSED
		 */
		// KundeLogik kl = new KundeLogik();
		// List<Kunde> searchlist = kl.listKunder( "navn", "" );
		// for(int i= 0; i<searchlist.size(); i++)
		// {
		// System.out.println(i+ " " + searchlist.get( i ).toString());
		// }

		/*
		 * test af updatekunde PASSED
		 */
		// Kunde kunde = new Kunde();
		// kunde.setCprid( 19 );
		// kunde.setCprnummer( "0406841545" );
		// kunde.setNavn( "Arne" );
		// kunde.setAdresse( "Aastr�de 12" );
		// kunde.setPostnummer( "8660" );
		// kunde.setTelefonnummer( "87654321" );
		// kunde.setEmail( "Arne@Aastr�de.dk" );
		// kunde.setKommentar( "Problem-Kunde" );
		//
		// KundeLogik kl = new KundeLogik();
		// kl.updateKunde( kunde );

		/*
		 * Test af deleteKunde PASSED
		 */
		// KundeLogik kl = new KundeLogik();
		// kl.deleteKunde( 19 );

	}

}
