package Opg22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class OpeningState extends DoorState implements ActionListener {

	private Timer t;

	public OpeningState(Door door) {
		super(door);
		t = new Timer(3000, this);
	}

	public void click() {
		System.out.println("CLICK!");
		t.stop();
		door.setCurrentState(door.getClosingState());
		door.getCurrentState().resetTimer();
	}

	public void complete() {
		door.setCurrentState(door.getOpenState());
		door.getCurrentState().resetTimer();
	}

	public void resetTimer() {
		t.restart();
	}

	@Override
	public String toString() {
		return "Opening";
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		t.stop();
		complete();

	}

}
