package opg3_okt10;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Kamp {

	private PropertyChangeSupport change = new PropertyChangeSupport(this);
	private List<EliteVinderEventListener> listeners = new ArrayList<>();
	private char raekke;
	private int nr;
	private Spiller vinder;
	private List<Spiller> deltagere;

	public Kamp() {
		this.deltagere = new ArrayList<>();
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public char getRaekke() {
		return raekke;
	}

	public void setRaekke(char raekke) {
		this.raekke = raekke;
	}

	public void addSpiller(Spiller s) {
		if (deltagere.size() < 2) {
			deltagere.add(s);
		} else {
			System.out.println("Deltagere til denne kamp er fuld");
		}
	}

	public void removeSpiller(Spiller s) {
		deltagere.remove(s);
	}

	public void setVinder(Spiller s) {
		if (raekke == 'E') {
			fireeliteVindert(new EliteVinderEvent(this));
		}
		vinder = s;
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		change.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListner(PropertyChangeListener l) {
		change.removePropertyChangeListener(l);
	}

	public void addEliteVinderEventListener(EliteVinderEventListener a) {
		if (!listeners.contains(a)) {
			listeners.add(a);
		}
	}

	public void removeEliteVinderEventListener(EliteVinderEventListener a) {
		if (listeners.contains(a)) {
			listeners.remove(a);
		}
	}

	private void fireeliteVindert(EliteVinderEvent event) {
		List<EliteVinderEventListener> list;
		synchronized (this) {
			list = new ArrayList<>(listeners);
		}
		for (EliteVinderEventListener ev : list) {
			ev.eliteVinder(event);
		}
	}
	

}
