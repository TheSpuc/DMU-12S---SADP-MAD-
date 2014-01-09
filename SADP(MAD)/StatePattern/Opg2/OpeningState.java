package Opg2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class OpeningState implements DoorStateInterface {

	private Door door;

	public OpeningState(Door door) {
		this.door = door;

	}

	@Override
	public void click() {
		door.getOpeningTimer().stop();
		door.setActiveState(door.getClosingState());
		door.getClosingTimer().restart();

	}

	@Override
	public void complete() {
		door.setActiveState(door.getOpenState());
		door.getTimeOutTimer().start();
		door.getOpeningTimer().stop();
	}

	@Override
	public void timeout() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "OPENING";
	}

}
