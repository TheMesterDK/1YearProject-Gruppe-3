package domain;

public class Finansieringsaftale {
	private int aftaleid;
	private int cprid;
	private int s�lgerid;
	private String chassisnummer;
	private double bel�b;
	private double udbetaling;
	private double rente;
	private int afviklingsperiode;
	private String oprettelsesdato;
	private String f�rsteafbetalingdato;
	private double afdragsbel�b;
	private double ekstraomkostninger;
	private double �op;

	public int getAftaleid() {
		return aftaleid;
	}

	public void setAftaleid(int aftaleid) {
		this.aftaleid = aftaleid;
	}

	public int getCprid() {
		return cprid;
	}

	public void setCprid(int cprid) {
		this.cprid = cprid;
	}

	public int getS�lgerid() {
		return s�lgerid;
	}

	public void setS�lgerid(int s�lgerid) {
		this.s�lgerid = s�lgerid;
	}

	public String getChassisnummer() {
		return chassisnummer;
	}

	public void setChassisnummer(String chassisnummer) {
		this.chassisnummer = chassisnummer;
	}

	public double getBel�b() {
		return bel�b;
	}

	public void setBel�b(double bel�b) {
		this.bel�b = bel�b;
	}

	public double getUdbetaling() {
		return udbetaling;
	}

	public void setUdbetaling(double udbetaling) {
		this.udbetaling = udbetaling;
	}

	public double getRente() {
		return rente;
	}

	public void setRente(double rente) {
		this.rente = rente;
	}

	public int getAfviklingsperiode() {
		return afviklingsperiode;
	}

	public void setAfviklingsperiode(int afviklingsperiode) {
		this.afviklingsperiode = afviklingsperiode;
	}

	public String getOprettelsesdato() {
		return oprettelsesdato;
	}

	public void setOprettelsesdato(String oprettelsesdato) {
		this.oprettelsesdato = oprettelsesdato;
	}

	public String getF�rsteafbetalingdato() {
		return f�rsteafbetalingdato;
	}

	public void setF�rsteafbetalingdato(String f�rsteafbetalingdato) {
		this.f�rsteafbetalingdato = f�rsteafbetalingdato;
	}

	public double getAfdragsbel�b() {
		return afdragsbel�b;
	}

	public void setAfdragsbel�b(double afdragsbel�b) {
		this.afdragsbel�b = afdragsbel�b;
	}

	public double getEkstraomkostninger() {
		return ekstraomkostninger;
	}

	public void setEkstraomkostninger(double ekstraomkostninger) {
		this.ekstraomkostninger = ekstraomkostninger;
	}

	public double get�op() {
		return �op;
	}

	public void set�op(double �op) {
		this.�op = �op;
	}

}
