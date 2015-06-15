package domain;

public class Sælger {
	private int sælgerid;
	private String sælgernavn;

	public int getSælgerid() {
		return sælgerid;
	}

	public void setSælgerid(int sælgerid) {
		this.sælgerid = sælgerid;
	}

	public String getSælgernavn() {
		return sælgernavn;
	}

	public void setSælgernavn(String sælgernavn) {
		this.sælgernavn = sælgernavn;
	}

	@Override
	public String toString() {
		return "Sælger [sælgerid=" + sælgerid + ", sælgernavn=" + sælgernavn
				+ "]";
	}

}
