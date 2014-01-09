package Opg1_4september;

public class Navn implements Comparable<Navn> {

	private String fornavn;
	private String efternavn;

	public Navn(String fornavn, String efternavn) {
		this.fornavn = fornavn;
		this.efternavn = efternavn;
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
	public int compareTo(Navn o) {
		int result = 0;
		if (!efternavn.equals(o.getEfternavn())) {
			result = efternavn.compareTo(o.getEfternavn());
		} else {
			result = fornavn.compareTo(o.getFornavn());
		}
		return result;
	}

	@Override
	public String toString() {
		return "Navn [fornavn=" + fornavn + ", efternavn=" + efternavn + "]";
	}

}
