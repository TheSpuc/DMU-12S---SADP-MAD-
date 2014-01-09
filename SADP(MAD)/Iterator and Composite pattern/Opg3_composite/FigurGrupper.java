package Opg3_composite;

public abstract class FigurGrupper {
	private String navn;

	public FigurGrupper(String navn) {
		this.navn = navn;
	}



	
	public void tegn() {
		System.out.println(navn);
	}

}
