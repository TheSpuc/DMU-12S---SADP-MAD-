package Opg2_Decorator;

public abstract class Bil {
	private int pris;
	private String beskrivelse;

	public Bil(int pris, String beskrivelse) {
		this.pris = pris;
		this.beskrivelse = beskrivelse;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public String getBeskrivelse() {
		return "Ford " + beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

}
