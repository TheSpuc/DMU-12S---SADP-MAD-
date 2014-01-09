package Opg1;

public class Kunde {

	private String tlfNr, mobNr, fornavn, efternavn;

	public Kunde(String tlfNr, String mobNr, String fornavn, String efternavn) {
		this.tlfNr = tlfNr;
		this.mobNr = mobNr;
		this.fornavn = fornavn;
		this.efternavn = efternavn;
	}

	public String getTlfNr() {
		return tlfNr;
	}

	public void setTlfNr(String tlfNr) {
		this.tlfNr = tlfNr;
	}

	public String getMobNr() {
		return mobNr;
	}

	public void setMobNr(String mobNr) {
		this.mobNr = mobNr;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	@Override
	public String toString() {
		return "Kunde [tlfNr=" + tlfNr + ", mobNr=" + mobNr + ", fornavn=" + fornavn + ", efternavn=" + efternavn
				+ "]";
	}

}
