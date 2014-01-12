package Opg22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ClosingState extends DoorState implements ActionListener {

	private Timer t;

	public ClosingState(Door door) {
		super(door);
		t = new Timer(4000, this);
	}

	public void complete() {
		door.setCurrentState(door.getClosedState());
	}

	public void click() {
		t.stop();
		door.setCurrentState(door.getOpeningState());
		door.getCurrentState().resetTimer();
	}

	public void actionPerformed(ActionEvent e) {
		t.stop();
		complete();
	}

	public void resetTimer() {
		t.restart();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Closing";
	}

}
