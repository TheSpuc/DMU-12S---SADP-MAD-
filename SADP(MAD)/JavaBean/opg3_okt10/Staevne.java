package opg3_okt10;

import java.util.ArrayList;
import java.util.List;

public class Staevne {

	private String title;
	private List<Kamp> kampe;

	public Staevne() {
		kampe = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addKamp(Kamp k) {
		kampe.add(k);
	}

	public void removeKamp(Kamp k) {
		kampe.remove(k);
	}

	public List<Kamp> getKampe() {
		return kampe;
	}

}
