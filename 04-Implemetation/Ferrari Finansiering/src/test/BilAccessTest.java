package test;

import java.sql.SQLException;

public class BilAccessTest {
	public static void main(String[] args) throws SQLException {

		/*
		 * Test af createBil PASSED
		 */
		// Bil bil = new Bil();
		//
		// bil.setChassisnummer( "a1b23n4567mk98" );
		// bil.setRegistreringsnummer( "aa12345" );
		// bil.setPris( 1000000 );
		// bil.setModel( "Ascari" );
		// bil.setÅrgang( "2005" );
		// bil.setBemærkninger( "Prototype" );
		//
		// BilLogik bl = new BilLogik();
		// bl.createBil( bil );
		//
		//
		// bil = new Bil();
		//
		// bil.setChassisnummer( "b1b23n4567mk98" );
		// bil.setRegistreringsnummer( "bb12345" );
		// bil.setPris( 2000000 );
		// bil.setModel( "Berlinetta Boxer" );
		// bil.setÅrgang( "1984" );
		// bil.setBemærkninger( "" );
		//
		// bl = new BilLogik();
		// bl.createBil( bil );
		//
		//
		// bil = new Bil();
		//
		// bil.setChassisnummer( "c1b23n4567mk98" );
		// bil.setRegistreringsnummer( "cc12345" );
		// bil.setPris( 300000 );
		// bil.setModel( "California" );
		// bil.setÅrgang( "2009" );
		// bil.setBemærkninger( "Import" );
		//
		// bl = new BilLogik();
		// bl.createBil( bil );

		/*
		 * Test af readBil PASSED
		 */
		// BilLogik bl = new BilLogik();
		// System.out.println(bl.readBil( "a1b23n4567mk98" ).toString());

		/*
		 * Test af listBil PASSED
		 */
		// BilLogik bl = new BilLogik();
		// List<Bil>searchlist = bl.listBiler( "model", "" );
		// for(int i=0; i<searchlist.size(); i++)
		// {
		// System.out.println(i+ " " + searchlist.get( i ).toString());
		// }

		/*
		 * Test af updateBil PASSED
		 */
		// Bil bil = new Bil();
		//
		// bil.setChassisnummer( "a1b23n4567mk98" );
		// bil.setRegistreringsnummer( "ab" );
		// bil.setPris( 1000000 );
		// bil.setModel( "Ascari" );
		// bil.setÅrgang( "2005" );
		// bil.setBemærkninger( "Prototype" );
		//
		// BilLogik bl = new BilLogik();
		// bl.updateBil( bil );

		/*
		 * Test af deleteBil PASSED
		 */
		// BilLogik bl = new BilLogik();
		// bl.deleteBil( "a1b23n4567mk98" );

	}

}
