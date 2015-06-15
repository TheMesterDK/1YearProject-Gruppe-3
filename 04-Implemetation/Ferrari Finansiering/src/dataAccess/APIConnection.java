package dataAccess;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;

public class APIConnection {

	private String kreditv�rdighed;
	private double rente;

	private String getRKIKredit(String cprnummer) {
		return CreditRator.i().rate(cprnummer).toString();
	}

	private double getBankRente() {
		return InterestRate.i().todaysRate();
	}

	public String getKreditV�rdighed(String cprnummer) {
		Thread kvthread = new Thread() {
			@Override
			public void run() {
				kreditv�rdighed = getRKIKredit(cprnummer);
			}
		};
		kvthread.start();

		try {
			kvthread.join();
		} catch (InterruptedException e1) {
			System.out.println("Exception fra getKreditV�rdighed");
		}

		return kreditv�rdighed;
	}

	public double getRente() {
		Thread rentethread = new Thread() {
			@Override
			public void run() {
				rente = getBankRente();
			}
		};
		rentethread.start();

		try {
			rentethread.join();
		} catch (InterruptedException e1) {
			System.out.println("Exception fra getRente");
		}

		return rente;
	}

}
