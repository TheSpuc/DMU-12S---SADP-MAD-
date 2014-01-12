package Opg22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class OpenState extends DoorState implements ActionListener {

	private Timer t;

	public OpenState(Door door) {
		super(door);
		t = new Timer(2000, this);
	}

	public void timeout() {
		door.setCurrentState(door.getClosingState());
		door.getCurrentState().resetTimer();
	}

	public void click() {
		t.stop();
		door.setCurrentState(door.getStayOpenState());
	}

	public void resetTimer() {
		t.restart();
	}

	@Override
	public String toString() {
		return "Open";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		t.stop();
		timeout();
	}

}
