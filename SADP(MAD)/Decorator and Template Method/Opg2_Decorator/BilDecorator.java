package Opg2_Decorator;

public abstract class BilDecorator extends Bil {

	private Bil bil;
	private String beskrivelse;

	public BilDecorator(int pris, String beskrivelse, Bil bil) {
		super(pris, beskrivelse);
		this.beskrivelse = beskrivelse;
		this.setBil(bil);
		// TODO Auto-generated constructor stub
	}

	public Bil getBil() {
		return bil;
	}

	public void setBil(Bil bil) {
		this.bil = bil;
	}

	public String getBeskrivelse() {
		return bil.getBeskrivelse() + ", " + this.beskrivelse;
	}

	public int getPris() {
		return bil.getPris() + super.getPris();
	}

}
